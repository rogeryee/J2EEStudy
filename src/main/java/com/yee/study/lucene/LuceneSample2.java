package com.yee.study.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

/**
 * User: Roger.Yee
 */
public class LuceneSample2
{
    public static Directory directory;

    public static void main(String[] args) throws Exception
    {
        test2();
    }

    public static void test2() throws Exception
    {
        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_CURRENT);

        // Store the index in memory:
        Directory directory = new RAMDirectory();
        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_CURRENT, analyzer);
        IndexWriter iwriter = new IndexWriter(directory, config);
        Document doc = new Document();
        String text = "This is the text to be indexed. He is in Shanghai office";
        doc.add(new Field("name", "Roger", TextField.TYPE_STORED));
        doc.add(new Field("fieldname1", text, TextField.TYPE_STORED));
        doc.add(new Field("customer_title", "Coping with my Tourette's has taught me the most valuable lesson that anyone could ever learn; and that is to never let anything stop you from chasing your dream, from working or playing or falling in love.  ", TextField.TYPE_STORED));
        iwriter.addDocument(doc);
        iwriter.close();

        // Now search the index:
        DirectoryReader ireader = DirectoryReader.open(directory);
        IndexSearcher isearcher = new IndexSearcher(ireader);
        // Parse a simple query that searches for "text":
        QueryParser parser = new QueryParser(Version.LUCENE_CURRENT, "customer_title", analyzer);
        Term term = new Term("name", "Roger");
        Query query = new TermQuery(term);
        ScoreDoc[] hits = isearcher.search(query, null, 1000).scoreDocs;
        // Iterate through the results:
        for (int i = 0; i < hits.length; i++)
        {
            Document hitDoc = isearcher.doc(hits[i].doc);
            System.out.println("hitDoc:" + hitDoc.get("name"));
        }
        ireader.close();
        directory.close();
    }

    public static void test1() throws Exception
    {
        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_CURRENT);

        // Store the index in memory:
        Directory directory = new RAMDirectory();
        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_CURRENT, analyzer);
        IndexWriter iwriter = new IndexWriter(directory, config);
        Document doc = new Document();
        String text = "This is the text to be indexed. He is in Shanghai office";
        doc.add(new Field("fieldname1", text, TextField.TYPE_STORED));
        doc.add(new Field("customer_title", "Coping with my Tourette's has taught me the most valuable lesson that anyone could ever learn; and that is to never let anything stop you from chasing your dream, from working or playing or falling in love.  ", TextField.TYPE_STORED));
        iwriter.addDocument(doc);
        iwriter.close();

        // Now search the index:
        DirectoryReader ireader = DirectoryReader.open(directory);
        IndexSearcher isearcher = new IndexSearcher(ireader);
        // Parse a simple query that searches for "text":
        QueryParser parser = new QueryParser(Version.LUCENE_CURRENT, "customer_title", analyzer);
        Query query = parser.parse("valuable");
        ScoreDoc[] hits = isearcher.search(query, null, 1000).scoreDocs;
        // Iterate through the results:
        for (int i = 0; i < hits.length; i++)
        {
            Document hitDoc = isearcher.doc(hits[i].doc);
            System.out.println("hitDoc:" + hitDoc.get("customer_title"));
        }
        ireader.close();
        directory.close();
    }
}