package pl.coderslab.users;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.utils.DbUtil;

import java.sql.*;
import java.util.Arrays;

public class UserDao {
    private static final String CREATE_USER_QUERY =
            "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
    public static final String CHANGE_DATA_QUERY =
            "UPDATE users SET username = ?, email = ?, password = ? WHERE id = ?;";

    //    public static final String CHANGE_PASSWORD_QUERY =
//            "UPDATE users SET password = ? WHERE id = ?;";
    public static final String FIND_USER_QUERY =
            "SELECT * FROM users WHERE id = ?;";
    public static final String DELETE_USER_QUERY =
            "DELETE FROM users WHERE id = ?;";
    public static final String FIND_ALL_QUERY =
            "SELECT * FROM users;";


    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public User create(User user) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, hashPassword(user.getPassword()));
            statement.executeUpdate();
            //Pobieramy wstawiony do bazy identyfikator, a następnie ustawiamy id obiektu user.
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User read(int userId) {

        try (Connection conn = DbUtil.getConnection()) {
            User user = new User();
            PreparedStatement preStmt = conn.prepareStatement(FIND_USER_QUERY);
            preStmt.setString(1, String.valueOf(userId));
            ResultSet rs = preStmt.executeQuery();

            while (rs.next()) {

                user.setUsername(rs.getString("username"));
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
            }
            return user;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String checkPassword(User user, String pswdToCheck) {
//         Metoda sprawdza, czy obiekt user, który przychodzi z MainDao, ma nowe hasło, czy hasło zahashowane.
        user = read(user.getId());
        if (user.getPassword().equals(pswdToCheck)) {
            return pswdToCheck;
        } else {
            return hashPassword(pswdToCheck);
        }

    }

    public void update(User user) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement preStmt = conn.prepareStatement(CHANGE_DATA_QUERY);
            preStmt.setString(1, user.getUsername());
            preStmt.setString(2, user.getEmail());
            preStmt.setString(3, checkPassword(user, user.getPassword()));
            preStmt.setInt(4, user.getId());
            preStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int userId) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement preStmt = conn.prepareStatement(DELETE_USER_QUERY);
            preStmt.setString(1, String.valueOf(userId));
            preStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User[] findAll() {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement preStmt = conn.prepareStatement(FIND_ALL_QUERY);
            ResultSet rs = preStmt.executeQuery();
            User[] allUsers = new User[0];
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                allUsers = copyArray(allUsers);
                allUsers[allUsers.length-1] = user;
            }
            return allUsers;


        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
    private User[] copyArray(User[] userArray){
        userArray = Arrays.copyOf(userArray,userArray.length+1);

        return userArray;
    }

}
