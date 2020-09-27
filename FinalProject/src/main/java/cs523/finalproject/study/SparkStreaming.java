package cs523.finalproject.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.text.DefaultEditorKit.CutAction;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.AbstractJavaRDDLike;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;

public class SparkStreaming
{
	public static void main(String[] args) throws Exception
	{

/*		
		// Create a Java Spark Context
		JavaSparkContext sc = new JavaSparkContext(new SparkConf().setAppName("wordCount").setMaster("local"));

		// Load our input data
		JavaRDD<String> lines = sc.textFile(args[0]);

		// Calculate word count
		JavaPairRDD<String, Integer> counts = lines
					.flatMap(line -> Arrays.asList(line.split(" ")))
					.mapToPair(w -> new Tuple2<String, Integer>(w, 1))
					.reduceByKey((x, y) -> x + y);

		Integer threshold = Integer.parseInt(args[2]);

		//Filter counts by Threshold
		JavaPairRDD<String, Integer> filtetCounts = counts.filter(c-> c._2>=threshold);

		//Convert words to chars to lowerCase, suppose A and a are the same
		JavaRDD<Tuple2<String,Integer>> chars = filtetCounts.flatMap(x-> 
			{ 
			
				List<String> l =  Arrays.asList(x._1.split("(?!^)")); 
				
				List<Tuple2<String,Integer>> t = l.stream().map(c-> 
				new Tuple2<String,Integer>(c.toLowerCase(), x._2) //toLowerCase  
				
				).collect(Collectors.toCollection(ArrayList::new));
	
				return t;  
			}
		);

		//Calculate char count
		JavaPairRDD<String,Integer> result = JavaPairRDD.fromJavaRDD(chars)
				.reduceByKey((x, y) -> x + y).sortByKey();//sort by Asc
		
		//save result as text file
		result.saveAsTextFile(args[1]);

		sc.close();
		*/
	}

}
