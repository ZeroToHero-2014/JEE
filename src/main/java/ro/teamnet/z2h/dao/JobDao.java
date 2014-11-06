package ro.teamnet.z2h.dao;

import ro.teamnet.z2h.domain.Job;
import ro.teamnet.z2h.domain.Job;
import ro.teamnet.z2h.utils.ResultSetToPojoConverter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by liviu.spiroiu on 11/3/14.
 */
public class JobDao {
    public ArrayList<Job> getAllJobs(Connection con) throws SQLException {
            Statement stmt = con.createStatement();
            String selectAllFromTableString = "SELECT job_id,job_title,min_salary,max_salary FROM Jobs";
            ResultSet rs = stmt.executeQuery(selectAllFromTableString);
            try {
                return ResultSetToPojoConverter.convertToJob(rs,con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt.close();
            rs.close();
            return new ArrayList<Job>();
        }
    
        public Job getJobById(Connection con, String id) throws SQLException {
            Statement stmt = con.createStatement();
            String selectAllFromTableString = "SELECT job_id,job_title,min_salary,max_salary " +
                    "FROM Jobs WHERE job_id = '" + id + "'";
            ResultSet rs = stmt.executeQuery(selectAllFromTableString);
            ArrayList<Job> jobs = ResultSetToPojoConverter.convertToJob(rs,con);
            stmt.close();
            return jobs.size() > 0 ? jobs.get(0) : null;
        }
}
