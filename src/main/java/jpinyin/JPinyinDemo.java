package jpinyin;

import com.github.stuxuhai.jpinyin.ChineseHelper;
import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

/**
 * JPinyin是一个汉字转拼音的Java开源类库, 还可以进行简繁转换.
 * @author Administrator
 *
 */
public class JPinyinDemo {
	public static void main(String[] args) throws PinyinException {
		String str = "施氏食狮史";
		
		//转换为带声调符号拼音
		String s1 = PinyinHelper.convertToPinyinString(str, " ");
		System.out.println(s1);
		//同上
		String s2 = PinyinHelper.convertToPinyinString(str, " ", PinyinFormat.WITH_TONE_MARK);
		System.out.println(s2);
		//数字标声调
		String s3 = PinyinHelper.convertToPinyinString(str, " ", PinyinFormat.WITH_TONE_NUMBER);
		System.out.println(s3);
		//不标声调
		String s4 = PinyinHelper.convertToPinyinString(str, " ", PinyinFormat.WITHOUT_TONE);
		System.out.println(s4);
		
		String cht = "遊戲暱稱";
		
		//繁体转简体
		String s5 = ChineseHelper.convertToSimplifiedChinese(cht);
		System.out.println(s5);
		
		//判断是否繁体
		System.out.println(ChineseHelper.isTraditionalChinese('鄰'));
		
		//判断是否为汉字
		System.out.println(ChineseHelper.isChinese('A'));  //false
	}
}
