package lab1.tbd.serviciovoluntariado.repositories;

import lab1.tbd.serviciovoluntariado.models.TareaHabilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class TareaHabilidadRepositoryImp implements TareaHabilidadRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public Long generateId() {
        Long newId;
        String queryId = "select max(id) form tarea_habilidad";
        Connection conn = sql2o.open();
        try(conn){
            newId=conn.createQuery(queryId)
                    .executeScalar(Long.class);
            if(newId == null)
                return (long) 0;
            else
                return newId;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally{
            conn.close();
        }
    }

    @Override
    public TareaHabilidad createTareaHabilidad(TareaHabilidad tareaHabilidad) {
        Long newId = generateId() + 1;
        final String query = "insert into tarea_habilidad(id, id_emehab, id_tarea) values (:newId, :id_emehab, :id_tarea)";
        Connection conn = sql2o.open();
        try (conn){
            conn.createQuery(query)
                    .addParameter("newId", newId)
                    .addParameter("id_tarea", tareaHabilidad.getId_emehab())
                    .addParameter("id_habilidad", tareaHabilidad.getId_tarea())
                    .executeUpdate();
            return tareaHabilidad;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally{
            conn.close();
        }
    }
    @Override
    public TareaHabilidad getTareaHabilidadById(Long id) {
        final String query = "select * from tarea_habilidad where id = :id";
        final TareaHabilidad tareaHabilidad;
        Connection conn = sql2o.open();
        try(conn){
            tareaHabilidad = conn.createQuery(query)
                    .addParameter("id",id)
                    .executeAndFetchFirst(TareaHabilidad.class);
            return tareaHabilidad;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally{
            conn.close();
        }
    }

    @Override
    public List<TareaHabilidad> getAllTareaHabilidad() {
        final String query = "Select * from tarea_habilidad";
        final List<TareaHabilidad> tareaHabilidadList;
        Connection conn = sql2o.open();
        try(conn){
            tareaHabilidadList = conn.createQuery(query)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(TareaHabilidad.class);
            return tareaHabilidadList;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally{
            conn.close();
        }
    }
    @Override
    public TareaHabilidad updateTareaHabilidad(TareaHabilidad tareaHabilidad) {
        final String query = "update tarea_habilidad set id_emehab = :id_emehab, id_tarea = :id_tarea where id = :id";
        Connection conn = sql2o.open();
        try(conn){
            conn.createQuery(query)
                    .addParameter("id", tareaHabilidad.getId())
                    .addParameter("id_emehab", tareaHabilidad.getId_emehab())
                    .addParameter("id_tarea", tareaHabilidad.getId_tarea())
                    .executeUpdate();
            return tareaHabilidad;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally{
            conn.close();
        }
    }
    @Override
    public void deleteTareaHabilidadById(Long id) {
        final String query = "delete from tarea_habilidad where id = :id";
        Connection conn = sql2o.open();
        try(conn){
            conn.createQuery(query)
                    .addParameter("id",id)
                    .executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            conn.close();
        }
    }
    @Override
    public void deleteTareaHabilidad() {
        final String query = "delete from tarea_habilidad";
        Connection conn = sql2o.open();
        try(conn){
            conn.createQuery(query)
                    .executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            conn.close();
        }
    }


}
