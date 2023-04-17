package lab1.tbd.serviciovoluntariado.repositories;

import lab1.tbd.serviciovoluntariado.models.EmeHabilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class EmeHabilidadRepositoryImp implements EmeHabilidadRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public Long generateId() {
        Long newId;
        String queryId = "select max(id) form eme_habilidad";
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
    public EmeHabilidad createEmeHabilidad(EmeHabilidad emeHabilidad) {
        Long newId = generateId() + 1;
        final String query = "insert into eme_habilidad(id, id_emergencia, id_habilidad) values (:newId, :id_emergencia, :id_habilidad)";
        Connection conn = sql2o.open();
        try (conn){
            conn.createQuery(query)
                    .addParameter("newId", newId)
                    .addParameter("id_emergencia", emeHabilidad.getId_emergencia())
                    .addParameter("id_habilidad", emeHabilidad.getId_habilidad())
                    .executeUpdate();
            return emeHabilidad;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally{
            conn.close();
        }
    }

    @Override
    public EmeHabilidad getEmeHabilidadById(Long id) {
        final String query = "select * from eme_habilidad where id = :id";
        final EmeHabilidad emeHabilidad;
        Connection conn = sql2o.open();
        try(conn){
            emeHabilidad = conn.createQuery(query)
                    .addParameter("id",id)
                    .executeAndFetchFirst(EmeHabilidad.class);
            return emeHabilidad;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally{
            conn.close();
        }
    }

    @Override
    public List<EmeHabilidad> getAllEmeHabilidad() {
        final String query = "Select * from eme_habilidad";
        final List<EmeHabilidad> emeHabilidadList;
        Connection conn = sql2o.open();
        try(conn){
            emeHabilidadList = conn.createQuery(query)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(EmeHabilidad.class);
            return emeHabilidadList;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally{
            conn.close();
        }
    }

    @Override
    public EmeHabilidad updateEmeHabilidad(EmeHabilidad emeHabilidad) {
        final String query = "update eme_habilidad set id_emergencia = :id_emergencia, id_habilidad = :id_habilidad where id = :id";
        Connection conn = sql2o.open();
        try(conn){
            conn.createQuery(query)
                    .addParameter("id", emeHabilidad.getId())
                    .addParameter("id_emergencia", emeHabilidad.getId_emergencia())
                    .addParameter("id_habilidad", emeHabilidad.getId_habilidad())
                    .executeUpdate();
            return emeHabilidad;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally{
            conn.close();
        }
    }

    @Override
    public void deleteEmeHabilidadById(Long id) {
        final String query = "delete from eme_habilidad where id = :id";
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
    public void deleteEmeHabilidad() {
        final String query = "delete from eme_habilidad";
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
