package com.dan.lucene;

import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

/**
 * 用来测试Lucene库的索引和搜索功能
 *
 */
public class LuceneTester {
        
    private String indexDir = "C:\\Users\\l81023541\\Desktop\\Index";
    private String dataDir = "D:\\MyEclipse\\Workspaces\\Shiro\\src\\main\\java\\com\\dan\\shiro\\realm";
    private Indexer indexer;
    private Searcher searcher;
    
    private void createIndex() throws IOException {
        indexer = new Indexer(indexDir);
        int numIndexed;
        long startTime = System.currentTimeMillis();
        numIndexed = indexer.createIndex(dataDir, new TextFileFilter());
        long endTime = System.currentTimeMillis();
        indexer.close();
        System.out.println(numIndexed + " File indexed, time taken: " + (endTime-startTime) + "ms");
    }
    
    private void search(String searchQuery) throws IOException, ParseException {
        searcher = new Searcher(indexDir);
        long startTime = System.currentTimeMillis();
        TopDocs hits = searcher.search(searchQuery);
        long endTime = System.currentTimeMillis();
        
        System.out.println(hits.totalHits + " documents found. Time: " + (endTime-startTime) + "ms");
        for (ScoreDoc scoreDoc : hits.scoreDocs) {
                Document doc = searcher.getDocument(scoreDoc);
                System.out.println("File: " + doc.get(LuceneConstants.FILE_PATH));
        }
        searcher.close();
    }
    
    public static void main(String[] args) {
        LuceneTester tester;
        tester = new LuceneTester();
        try {
                tester.createIndex();
                tester.search("zhang");
        } catch (IOException e) {
                e.printStackTrace();
        } catch (ParseException e) {
                e.printStackTrace();
        }
    }
        
}