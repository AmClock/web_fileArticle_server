package service;

import java.util.Map;

import vo.Article;

public interface ImoxionService {
	public Map<String, Object> mainFuction(String path);

	public void writeArticle(Article article, String path);

	public Article detailPage(int no, String path);

	public void updateArticle(Article article, String path);

	public void deleteArticle(int no, String path);
}
