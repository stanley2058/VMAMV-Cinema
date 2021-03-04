package notification;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class Notification {

    public static String getNotification(String userID)
	{
		try {

            String a = Integer.parseInt(userID) % 2 == 0 ? "Even" : "Odd";


			System.out.println("MongoDBConnect to database begin");
            //連線到MongoDB服務 如果是遠端連線可以替換“localhost”為伺服器所在IP地址
			
            //通過連線認證獲取MongoDB連線
            MongoClient mongoClient = MongoClients.create("mongodb://140.121.196.23:4116");
            
            //連線到資料庫(schema)
            MongoDatabase mongoDatabase = mongoClient.getDatabase("Notification");
            System.out.println("MongoDBConnect to database successfully");

            //建立集合
            String result = "[";
            MongoCollection<Document> collection = mongoDatabase.getCollection("notification");


            FindIterable<Document> fi = collection.find();
            MongoCursor<Document> cursor = fi.iterator();
            while(cursor.hasNext()) 
            {
            	result += cursor.next().toJson();
            	if(cursor.hasNext())
            		result += ",";
            }
            result += "]";
            System.out.println("Connect to database successfully");
            return result;
            
        } catch (Exception e) {  
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            return "{}";
        }
	}
	
	public static String newNotification(String userID, String content) 
	{
		try {  
            
			System.out.println("MongoDBConnect to database begin");
            //連線到MongoDB服務 如果是遠端連線可以替換“localhost”為伺服器所在IP地址
			
            //通過連線認證獲取MongoDB連線
            MongoClient mongoClient = MongoClients.create("mongodb://140.121.196.23:4116");
            
            //連線到資料庫(schema)
            MongoDatabase mongoDatabase = mongoClient.getDatabase("Notification");
            System.out.println("MongoDBConnect to database successfully");

            //選擇到collection
            MongoCollection<Document> collection = mongoDatabase.getCollection("notification");
            
            //新增新資料
            Document options =  new Document();
            options.put("account", userID);
            options.put("content", content);
            //已讀未讀 直接用布林表示
            options.put("status", false);
            
            //插入
            collection.insertOne(options);
            return "success";
            
        } catch (Exception e) {  
            return e.getClass().getName() + ": " + e.getMessage() ;
        }
	}
	
	public static void setNotificationRead(String ID) 
	{
		try {  
            
			System.out.println("MongoDBConnect to database begin");
            //連線到MongoDB服務 如果是遠端連線可以替換“localhost”為伺服器所在IP地址
			
            //通過連線認證獲取MongoDB連線
            MongoClient mongoClient = MongoClients.create("mongodb://140.121.196.23:4116");
            
            //連線到資料庫(schema)
            MongoDatabase mongoDatabase = mongoClient.getDatabase("Notification");
            System.out.println("MongoDBConnect to database successfully");

            //選擇到collection
            MongoCollection<Document> collection = mongoDatabase.getCollection("notification");
            
            //找到要修改的資料
            Document options =  new Document();
            options.append("_id", new ObjectId(ID));
            
            //設定為已經讀了
            Document updateOptions = new Document();
            updateOptions.append("status", true);
            Document updateDocument = new Document(); 
            updateDocument.append("$set", updateOptions); 
            
            //更新
            collection.updateOne(options, updateDocument);
            
            
        } catch (Exception e) {  
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
	}
	public static String deleteNotification(String ID) 
	{
		try {  
            
			System.out.println("MongoDBConnect to database begin");
            //連線到MongoDB服務 如果是遠端連線可以替換“localhost”為伺服器所在IP地址
			
            //通過連線認證獲取MongoDB連線
            MongoClient mongoClient = MongoClients.create("mongodb://140.121.196.23:4116");
            
            //連線到資料庫(schema)
            MongoDatabase mongoDatabase = mongoClient.getDatabase("Notification");
            System.out.println("MongoDBConnect to database successfully");

            //選擇到collection
            MongoCollection<Document> collection = mongoDatabase.getCollection("notification");
            
            //找到最後一個並刪除
            collection.deleteOne(collection.find().sort(new BasicDBObject("_ID",-1)).first());
            return "success";
            
        } catch (Exception e) {  
            return e.getClass().getName() + ": " + e.getMessage() ;
        }
	}
}
