package com.bankMgmtApplication.dao;

import com.bankMgmtApplication.model.Transaction;
import com.bankMgmtApplication.model.User;
import com.bankMgmtApplication.model.UserBalance;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class bankdao implements bankdaoInterface{
//    @Autowired
//    JdbcTemplate jdbcTemplate;
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public boolean signUp(User user) {
        if (isUsernameUnique(user.getUsername())) {
            entityManager.persist(user);
            // Assuming there's a method to get the user ID after persisting
            UserBalance ub = new UserBalance();
            ub.setUsername(user.getUsername());
            ub.setBalance(0);
            entityManager.persist(ub);
            return true;
        }
        return false;
    }
    private boolean isUsernameUnique(String username) {
        Query query = entityManager.createQuery("SELECT COUNT(u) FROM User u WHERE u.username = :username");
        query.setParameter("username", username);
        Long count = (Long) query.getSingleResult();
        return count == 0;
    }

    @Override
    public boolean logIn(User user) {
        Query query = entityManager.createQuery("SELECT COUNT(u) FROM User u WHERE u.username = :username AND u.password = :password");
        query.setParameter("username", user.getUsername());
        query.setParameter("password", user.getPassword());
        Long count = (Long) query.getSingleResult();
        return count > 0;
    }
    @Override
    public List<User> showUsers() {
        Query query = entityManager.createQuery("FROM User");
        return query.getResultList();
    }

    @Override
    public int addAmount(Transaction t) {
        entityManager.persist(t);
        return 1;
    }

    @Override
    public int withdrawAmount(Transaction t) {
        entityManager.persist(t);
        return 1;
    }


    @Override
    public List<Transaction> showBalance(String username) {
        Query query = entityManager.createQuery("FROM Transaction WHERE username = :username");
        query.setParameter("username", username);
        return query.getResultList();
    }
    @Override
    public int getUserTotalBalance(String username) {
        try {
            Query query = entityManager.createQuery("SELECT balance FROM UserBalance WHERE username = :username");
            query.setParameter("username", username);
            Integer totalBalance = (Integer) query.getSingleResult();
            System.out.println("userbalance : "+totalBalance);
            return (totalBalance != null) ? totalBalance : 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public void updateTotBalance(String username, int amount, String action) {
        String hql = "UPDATE UserBalance SET balance = balance + :amount WHERE username = :username";
        Query query = entityManager.createQuery(hql);
        query.setParameter("amount", (action.equals("withdraw") ? -amount : amount));
        query.setParameter("username", username);
        query.executeUpdate();
    }
}
