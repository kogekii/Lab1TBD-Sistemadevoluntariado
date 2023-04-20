package lab1.tbd.serviciovoluntariado.repositories;

import lab1.tbd.serviciovoluntariado.models.Emergencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class EmergenciaRepositoryImp implements EmergenciaRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countEmergencia() {
        String sql = "SELECT COUNT(*) FROM emergencia";
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
    public List<Emergencia> getAllEmergencia() {
        String sql = "SELECT * FROM emergencia";
        Connection conn = sql2o.open();
        try (conn) {
            return conn.createQuery(sql).executeAndFetch(Emergencia.class);
        }catch(Exception e){
            System.out.println(e);
            return null;
        }finally{
            conn.close();
        }
    }

    @Override
    public Emergencia getEmergenciaById(int id) {
        String sql = "SELECT * FROM emergencia WHERE id = :id";
        Connection conn = sql2o.open();
        try (conn) {
            return conn.createQuery(sql).addParameter("id", id).executeAndFetchFirst(Emergencia.class);
        }catch(Exception e){
            System.out.println(e);
            return null;
        }finally{
            conn.close();
        }
    }

    @Override
    public Emergencia createEmergencia(Emergencia t) {
        String sql = "INSERT INTO emergencia (id, nombre, descrip, finicio, " +
                "ffin, id_institucion) " +
                "VALUES (:id, :nombre, :descrip, :finicio, :ffin, :id_institucion)";
        Connection conn = sql2o.open();
        try (conn) {
            int id = (int) conn.createQuery(sql,true)
                    .bind(t)
                    .executeUpdate()
                    .getKey();
            t.setId((long) id);
            return t;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }finally{
            conn.close();
        }
    }

    @Override
    public Emergencia updateEmergencia(Emergencia t) {
        String sql = "UPDATE emergencia SET nombre = :nombre, descrip = :descrip, " +
                "finicio = :finicio, ffin = :ffin, id_institucion = :id_institucion " +
                "WHERE id = :id";
        Connection conn = sql2o.open();
        try (conn) {
            conn.createQuery(sql)
                    .bind(t)
                    .executeUpdate();
            return t;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }finally{
            conn.close();
        }
    }
    @Override
    public void deleteEmergenciaById(int id) {
        String sql = "DELETE FROM emergencia WHERE id = :id";
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
