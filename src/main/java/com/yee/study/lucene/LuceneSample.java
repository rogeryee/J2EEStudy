package com.yee.study.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.io.*;

/**
 * User: Roger.Yee
 * 本例展示了如何使用Lucene对数据文件创建索引，并且进行全文检索的例子。
 */
public class LuceneSample
{
    public static String PATH_INDEX = System.getProperty("user.dir") + "\\src\\com\\yee\\study\\lucene\\index";
    public static String PATH_FILE = System.getProperty("user.dir") + "\\src\\com\\yee\\study\\lucene\\content";

    public static void main(String[] args) throws Exception
    {
        LuceneSample.createIndex();
//        LuceneSample.doSearch("am");
    }

    public static void createIndex() throws Exception
    {
        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_4_9);
        Directory directory = FSDirectory.open(new File(PATH_INDEX)); // Store an index on disk.

        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_4_9, analyzer);
        IndexWriter iwriter = new IndexWriter(directory, config);

        File folder = new File(LuceneSample.PATH_FILE);

        if (folder.isDirectory())
        {
            String[] files = folder.list();
            for (int i = 0; i < files.length; i++)
            {
                File file = new File(folder, files[i]);

                Document doc = new Document();

                FileInputStream is = new FileInputStream(file);
                Reader reader = new BufferedReader(new InputStreamReader(is));

                //字符串 StringField LongField TextField
                Field pathField = new StringField("path", file.getAbsolutePath(), Field.Store.YES);
                Field contenField = new TextField("contents", reader);

                //添加字段
                doc.add(contenField);
                doc.add(pathField);

                System.out.println("正在建立索引 : " + file + "");
                iwriter.addDocument(doc);
            }
        }
        iwriter.close();
    }

    public static void doSearch(String keyword) throws Exception
    {
        // Now search the index:
        System.out.println("正在检索关键字 : " + keyword);

        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_4_9);
        Directory directory = FSDirectory.open(new File(PATH_INDEX));
        DirectoryReader ireader = DirectoryReader.open(directory);
        IndexSearcher isearcher = new IndexSearcher(ireader);

        // Parse a simple query that searches for "text":
        QueryParser parser = new QueryParser(Version.LUCENE_4_9, "contents", analyzer);
        Query query = parser.parse(keyword);
        ScoreDoc[] hits = isearcher.search(query, null, 1000).scoreDocs;

        if (hits.length == 0)
        {
            System.out.println("对不起，没有找到您要的结果。");
        }
        else
        {
            for (int i = 0; i < hits.length; i++)
            {
                Document hitDoc = isearcher.doc(hits[i].doc);
                System.out.println("这是第" + (i+1) + "个检索到的结果，文件名为：" + hitDoc.get("path"));
            }
        }
        ireader.close();
        directory.close();
    }
}