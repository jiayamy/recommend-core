package com.wondertek.mobilevideo.core.recommend.util;

import java.io.File;
import java.util.List;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.CachingRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class RecommendDeal{
    int userID;
    int length;
    
    public RecommendDeal(int userID){
        this.userID=userID;
        
    }
    public List<RecommendedItem> mySlopeOneRecommender(long userID,int size){  
        List<RecommendedItem> recommendations = null;  
        try {  
            DataModel model = new FileDataModel(new File("D:\\ratings.txt"));//构造数据模型  
//            Recommender recommender = new CachingRecommender(new SlopeOneRecommender(model));//构造推荐引擎  
//            recommendations = recommender.recommend(userID, size);//得到推荐结果  
        } catch (Exception e) {  
            // TODO: handle exception  
            e.printStackTrace();  
        }  
        return recommendations;  
    }  
    //*******************基于用户的推荐********************
    public List<RecommendedItem> userBasedRecommender() {  
        // step:1 构建模型 2 计算相似度 3 查找k紧邻 4 构造推荐引擎 
    List<RecommendedItem> recommendations = null;  
    try {  
        length=(int)((Math.random()+3)*10);
        
        DataModel model = new FileDataModel(new File("D:\\ratings.txt"));//构造数据模型，Database-based  
        
        UserSimilarity similarity = new PearsonCorrelationSimilarity(model);//用PearsonCorrelation 算法计算用户相似度  
        UserNeighborhood neighborhood = new NearestNUserNeighborhood(length, similarity, model);//计算用户的“邻居”，这里将与该用户最近距离为 3 的用户设置为该用户的“邻居”。  
        Recommender recommender = new CachingRecommender(new GenericUserBasedRecommender(model, neighborhood, similarity));//构造推荐引擎，采用 CachingRecommender 为 RecommendationItem 进行缓存  
        recommendations = recommender.recommend(this.userID, 20);//得到推荐的结果，20是推荐的数目  
    } catch (Exception e) {  
        // TODO: handle exception  
        e.printStackTrace();  
    }  
    return recommendations;  
}
    //**********************基于项目的推荐*******************
    public List<RecommendedItem> ItemBasedRecommender(){  
        List<RecommendedItem> recommendations = null;  
        length=(int)((Math.random()+1)*10);
        try {  
            DataModel model = new FileDataModel(new File("D:\\ratings.txt"));//构造数据模型，File-based  
            ItemSimilarity similarity = new PearsonCorrelationSimilarity(model);//计算内容相似度  
            Recommender recommender = new GenericItemBasedRecommender(model, similarity);//构造推荐引擎  
            recommendations = recommender.recommend(this.userID, length);//得到推荐接过  
        } catch (Exception e) {  
            // TODO: handle exception  
            e.printStackTrace();  
        }  
        return recommendations;  
    }  
    
}