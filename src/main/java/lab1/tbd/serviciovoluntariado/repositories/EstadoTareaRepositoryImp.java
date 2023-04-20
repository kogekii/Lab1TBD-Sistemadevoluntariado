package lab1.tbd.serviciovoluntariado.repositories;

import lab1.tbd.serviciovoluntariado.models.EstadoTarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class EstadoTareaRepositoryImp implements EstadoTareaRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countEstadoTarea() {
        String sql = "SELECT COUNT(*) FROM estado_tarea";
        Connection conn = sql2o.open();
        try (conn) {
            return conn.createQuery(sql).executeScalar(Integer.class);
        }catch(Exception e){
            System.out.println(e);
            return 0;
        }finally{
            conn.close();
        }
    }

    @Override
    public List<EstadoTarea> getAllEstadoTarea() {
        String sql = "SELECT * FROM estado_tarea";
        Connection conn = sql2o.open();
        try (conn) {
            return conn.createQuery(sql).executeAndFetch(EstadoTarea.class);
        }catch(Exception e){
            System.out.println(e);
            return null;
        }finally{
            conn.close();
        }
    }

    @Override
    public EstadoTarea getEstadoTareaById(int id) {
        String sql = "SELECT * FROM estado_tarea WHERE id = :id";
        Connection conn = sql2o.open();
        try (conn) {
            return conn.createQuery(sql).addParameter("id", id).executeAndFetchFirst(EstadoTarea.class);
        }catch(Exception e){
            System.out.println(e);
            return null;
        }finally{
            conn.close();
        }
    }
    @Override
    public EstadoTarea createEstadoTarea(EstadoTarea s) {
        String sql = "INSERT INTO estado_tarea (id, descrip) " +
                "VALUES (:id, :descrip)";
        Connection conn = sql2o.open();
        try (conn) {
            int id = (int) conn.createQuery(sql,true)
                    .bind(s)
                    .executeUpdate()
                    .getKey();
            s.setId((long) id);
            return s;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }finally{
            conn.close();
        }
    }

    @Override
    public EstadoTarea updateEstadoTarea(EstadoTarea s) {
        String sql = "UPDATE estado_tarea SET descrip = :descrip WHERE id = :id";
        Connection conn = sql2o.open();
        try (conn) {
            conn.createQuery(sql)
                    .bind(s)
                    .executeUpdate();
            return s;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }finally{
            conn.close();
        }
    }

    @Override
    public void deleteEstadoTareaById(int id) {
        String sql = "DELETE FROM estado_tarea WHERE id = :id";
        Connection conn = sql2o.open();
        try (conn) {
            conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }finally{
            conn.close();
        }
    }

}
