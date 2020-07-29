package algorithm.test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SegmentTest {

    private static List<Segment> segments = new LinkedList<>();

    static {
        //预设时段
        segments.add(new Segment(0, 4, "晚安"));
        segments.add(new Segment(5, 11, "早安"));
        segments.add(new Segment(12, 17, "午安"));
        segments.add(new Segment(18, 23, "晚安"));
    }

    public static void main(String[] args) {
        System.out.println(segments);
        set(new Segment(17, 18, "傍晚啦"));
        System.out.println(segments);
    }

    public static void set(Segment entity) {
        Integer startHour = entity.getStartHour();
        Integer endHour = entity.getEndHour();

        //查询出所有受当前设置影响的记录, 调整其开始结束时间
        List<Segment> rows = getEffectedRows(startHour, endHour);

        //1.没有受影响的记录, 直接保存新设置
        if (rows.size() == 0) {
            segments.add(entity);
            return ;
        }

        //2.有一行受影响, 即当前设置的时段可能等于或被包含在这条记录的时段里
        if (rows.size() == 1) {
            Segment h = rows.get(0);
            Integer hStartHour = h.getStartHour();
            Integer hEndHour = h.getEndHour();

            //2-1.受影响行时段与当前设置的相等, 只更新内容即可
            if (startHour.equals(hStartHour) && endHour.equals(hEndHour)) {
                h.setGreeting(entity.getGreeting());
                return ;
            }

            //2-2.当前设置完全被包含在当前已存在的一个设置中
            //查出受影响时段的前一段, 修改前一段的结束时间
            Segment preSegment = getPrev(h);
            boolean hasPreSegment = (preSegment != null);
            if (hasPreSegment) {
                preSegment.setEndHour(startHour - 1);
            }
            //查出受影响时段的后一段, 修改后一段的开始时间
            Segment nextSegment = getNext(h);
            boolean hasNextSegment = (nextSegment != null);
            if (hasNextSegment) {
                nextSegment.setStartHour(entity.getEndHour() + 1);
            }
            //前后都有设置, 删除受影响时段
            if (hasPreSegment && hasNextSegment) {
                segments.remove(h);
            }
            //没有前一段
            if (!hasPreSegment) {
                h.setEndHour(startHour - 1);
            }
            //没有后一段
            if (!hasNextSegment) {
                h.setStartHour(endHour + 1);
            }

            //2-2-4.保存新设置
            segments.add(entity);
            return ;
        }

        //3.有两行及以上受影响
        if (rows.size() >= 2) {
            //找出受影响的首、尾时段进行修改
            Segment first = rows.get(0);
            Segment last = rows.get(rows.size() - 1);

            if (Objects.equals(first.getStartHour(), startHour) && first.getEndHour() < endHour) {
                segments.remove(first);
            } else {
                first.setEndHour(startHour - 1);
            }

            if (Objects.equals(last.getEndHour(), endHour) && last.getStartHour() > startHour) {
                segments.remove(last);
            } else {
                last.setStartHour(endHour + 1);
            }

            //中间的直接删除
            for (int i = 1, size = rows.size() - 1; i < size; i++) {
                segments.remove(rows.get(i));
            }

            //保存新设置
            segments.add(entity);
        }

        segments.sort(Comparator.comparingInt(Segment::getStartHour));
    }

    private static List<Segment> getEffectedRows(int startHour, int endHour) {
        return segments.stream().filter(s -> effectedRowCondition(startHour, endHour, s.getStartHour(), s.getEndHour()))
                .collect(Collectors.toList());
    }

    private static boolean effectedRowCondition(int startHour, int endHour, int sStartHour, int sEndHour) {
        return (sStartHour <= startHour && startHour <= sEndHour)
                || (startHour <= sStartHour && sEndHour <= endHour)
                || (sStartHour <= sEndHour && endHour <= sEndHour);
    }

    private static Segment getPrev(Segment segment) {
        for (Segment s : segments) {
            if (s.getEndHour() == segment.getStartHour() - 1) {
                return s;
            }
        }
        return null;
    }

    private static Segment getNext(Segment segment) {
        for (Segment s : segments) {
            if (s.getStartHour() == segment.getEndHour() + 1) {
                return s;
            }
        }
        return null;
    }
}
