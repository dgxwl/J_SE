package file;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 读取指定目录及其所有子目录, 用json格式表示其层次结构
 * 
 * @author Administrator
 *
 */
public class Test_readDirAsJson {
	public static void main(String[] args) {
		File root = new File("./src");
		DirTreeVO d = new DirHierarchyHandler(root).getHierarchy();
		System.out.println(d);
	}
	
	private static class DirHierarchyHandler {
		File rootPath;
		Map<String, String> parentNameMap = new HashMap<>();
		Map<String, DirTreeVO> voMap = new HashMap<>();
		List<DirTreeVO> subVOs = new ArrayList<>(16);
		
		public DirHierarchyHandler(File rootPath) {
			this.rootPath = rootPath;
		}
		
		public DirTreeVO getHierarchy() {
			getAllSubDir(rootPath);
			
			for (DirTreeVO dirTreeVO : subVOs) {
				String parentName = parentNameMap.get(dirTreeVO.getName());
				DirTreeVO parentVo = voMap.get(parentName);
				if (parentVo != null) {
					parentVo.getChildren().add(dirTreeVO);
				}
			}
			
			return voMap.get(rootPath.getName());
		}
		
		private void getAllSubDir(File rootPath) {
			DirTreeVO vo = new DirTreeVO();
			vo.setName(rootPath.getName());
			
			subVOs.add(vo);
			voMap.put(rootPath.getName(), vo);
			if (rootPath.equals(this.rootPath)) {
				parentNameMap.put(rootPath.getName(), null);
			} else {
				String parentFullName = rootPath.getParent().lastIndexOf(File.separator)==-1?
						rootPath.getParent():
						rootPath.getParent().substring(rootPath.getParent().lastIndexOf(File.separator) + 1);
				parentNameMap.put(rootPath.getName(), parentFullName);
			}
			
			File[] sub = rootPath.listFiles((file) -> {
				return file.isDirectory();
			});
			
			for (int i = 0; i < sub.length; i++) {
				getAllSubDir(sub[i]);
			}
		}
	}
}



//节点类
class DirTreeVO {
	private String name;
	private List<DirTreeVO> children = new ArrayList<>(16);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DirTreeVO> getChildren() {
		return children;
	}

	public void setChildren(List<DirTreeVO> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "{\"name\": \"" + name + "\", \"children\": " + children + "}";
	}

}