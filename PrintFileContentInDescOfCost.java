
 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
 
public class PrintFileContentInDescOfCost {
 
    public static void main(String args[]){
        BufferedReader br = null;
        String strLine = "";
        try {
            br = new BufferedReader( new FileReader(args[0]));
            Map<Double,String> content=new TreeMap<Double,String>();
            while( (strLine = br.readLine()) != null){
                content.put(findCost(strLine),strLine);
            }
            //System.out.println("Content is : "+content);
            Object obj[]=content.keySet().toArray();
            for(int i=obj.length-1;i>=0;i--){
            	//System.out.println(obj[i]+"=="+content.get(obj[i]));
            	System.out.println(content.get(obj[i]));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Unable to find the file: fileName");
        } catch (IOException e) {
            System.err.println("Unable to read the file: fileName");
        }
    }

	private static double findCost(String strLine) {
		String str[]=strLine.split(",");
		double cost=0.0;
		for (int i = 0; i < str.length; i++) {
			cost+=Double.parseDouble(str[i].substring(str[i].indexOf("-")+1).trim());
		}
		return cost;
	}
}