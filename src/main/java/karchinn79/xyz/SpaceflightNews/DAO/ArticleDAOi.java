//package karchinn79.xyz.SpaceflightNews.DAO;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.Query;
//
//
//@Repository
//public class ArticleDAOi {
//@Autowired
//SessionFactory sessionFactory;
//
//    @Transactional
//    public void clearDB(){
//            Session session = sessionFactory.getCurrentSession();
//            Query query = session.createQuery("DELETE FROM articles");
//            query.executeUpdate();
//            session.close();
//
//    }
//
//}
