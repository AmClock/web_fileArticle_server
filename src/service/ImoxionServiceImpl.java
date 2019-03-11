package service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import dao.FileDAO;
import vo.Article;

public class ImoxionServiceImpl implements ImoxionService {

	private FileDAO fileDAO;

	public void setFileDAO(FileDAO fileDAO) {
		this.fileDAO = fileDAO;
	}//setFileDAO end

	@Override
	public Map<String, Object> mainFuction(String path) {
		Map<String, Object> map = new ConcurrentHashMap<>();
		map.put("newFile", fileDAO.makeFile(path));
		map.put("list", fileDAO.readList(path));
		return map;
	}//mainFuction end

	@Override
	public void writeArticle(Article article, String path) {
		// TODO Auto-generated method stub
		fileDAO.writeFile(path, article);
	}// writeArticle end

	@Override
	public Article detailPage(int no, String path) {
		// TODO Auto-generated method stub
		return fileDAO.readDetail(no, path);
	}//detailPage end

	@Override
	public void updateArticle(Article article, String path) {
		// TODO Auto-generated method stub
		fileDAO.updateForm(path, article);
	}//updateArticle end

	@Override
	public void deleteArticle(int no, String path) {
		// TODO Auto-generated method stub
		fileDAO.deleteLine(no, path);
	}//deleteArticle end

}// ImoxionServiceImpl end
