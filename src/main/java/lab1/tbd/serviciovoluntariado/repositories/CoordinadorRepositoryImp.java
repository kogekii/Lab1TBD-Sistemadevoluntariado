package lab1.tbd.serviciovoluntariado.repositories;

import lab1.tbd.serviciovoluntariado.models.Coordinador;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

@Repository

public class CoordinadorRepositoryImp implements CoordinadorRepository
{
    @Autowired
    private Sql2o sql2o;

    @Override
    public Long getIdCoordinadorMayor(){
        try(Connection conn = sql2o.open()){
            Coordinador auxiliar = conn.createQuery("SELECT * FROM coordinador ORDER BY id DESC").executeAndFetchFirst(Coordinador.class);
            return auxiliar.getId();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return 1L;
        }
    }

    @Override
    public Coordinador createCoordinador(Coordinador coordinador) {
        final String sql =
            "INSERT INTO coordinador (nombre, apellido,estado_salud,password,correo_electronico,id_institucion) " +
            "VALUES (:nombre, :apellido, :estado_salud, :password, :correo_electronico, :id_institucion)";

        try(Connection conn = sql2o.open()){
            Query query = conn.createQuery(sql)
                .addParameter("nombre", coordinador.getNombre())
                .addParameter("apellido", coordinador.getApellido())
                .addParameter("estado_salud", coordinador.getEstado_salud())
                .addParameter("password", coordinador.getPassword())
                .addParameter("correo_electronico",coordinador.getCorreo_electronico())
                .addParameter("id_institucion",coordinador.getId_institucion());
            Long cid = query.executeUpdate().getKey(Coordinador.class);
            System.out.println("REGISTER Coordinador(id=" + cid + ")");
            Coordinador coord = conn.createQuery("SELECT * FROM coordinador WHERE id = :cid")
                .addParameter("cid", cid)
                .executeAndFetchFirst(Coordinador.class);
            conn.close();
            return coord;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public List<Coordinador> getAllCoordinador() {
        final String sql = "SELECT * FROM coordinador";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .executeAndFetch(Coordinador.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Coordinador getCoordinadorById(Long id){
        String sql = "SELECT * FROM coordinador WHERE id = :eid";

        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .addParameter("eid", id)
                    .executeAndFetchFirst(Coordinador.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String updateCoordinador(Long id, Coordinador coordinador) {
        String updateSql = "UPDATE coordinador " +
                "SET nombre = :coordinadorNombre,apellido = :coordinadorApellido, estado_salud = :coordinadorEstado_salud,"
                + "password =:coordinadorPassword, correo_electronico =:coordinadorCorreo_electronico, id_institucion =:coordinadorId_institucion, "
                + "updated_at = :coordinadorFechaActualizacion " +
                "WHERE id = :coordinadorID";
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        try (Connection con = sql2o.open()) {
            Coordinador antiguo = con.createQuery("SELECT * FROM coordinador where id = :idE")
                    .addParameter("idE", id)
                    .executeAndFetchFirst(Coordinador.class);

            //Se verifica si existe la tupla que se desea actualizar
            if(antiguo == null){
                return ("No existe el coordinador con id: " + id);
            }

            //Se ejectua la actualizacion, llenando los parametros de la consulta segun corresponda
            Query consulta = con.createQuery(updateSql);
            consulta.addParameter("coordinadorID", id);

            if(coordinador.getNombre() != null){
                consulta.addParameter("coordinadorNombre", coordinador.getNombre());
            } else {
                consulta.addParameter("coordinadorNombre", antiguo.getNombre());
            }
            if(coordinador.getApellido() != null){
                consulta.addParameter("coordinadorApellido", coordinador.getApellido());
            } else {
                consulta.addParameter("coordinadorApellido", antiguo.getApellido());
            }
            if(coordinador.getEstado_salud() != null){
                consulta.addParameter("coordinadorEstado_salud", coordinador.getEstado_salud());
            } else {
                consulta.addParameter("coordinadorEstado_salud", antiguo.getEstado_salud());
            }
            if(coordinador.getPassword() != null){
                consulta.addParameter("coordinadorPassword", coordinador.getPassword());
            } else {
                consulta.addParameter("coordinadorPassword", antiguo.getPassword());
            }
            if(coordinador.getCorreo_electronico() != null){
                consulta.addParameter("coordinadorCorreo_electronico", coordinador.getCorreo_electronico());
            } else {
                consulta.addParameter("coordinadorCorreo_electronico", antiguo.getCorreo_electronico());
            }
            if(coordinador.getId_institucion() != null){
                consulta.addParameter("coordinadorId_institucion", coordinador.getId_institucion());
            } else {
                consulta.addParameter("coordinadorId_institucion", antiguo.getId_institucion());
            }

            //Se cambia la fecha de actualizacion
            consulta.addParameter("coordinadorFechaActualizacion",timestamp);

            consulta.executeUpdate();

            return ("El coordinador de id: " + id + " se actualizo correctamente");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String deleteCoordinador(Long id) {
        String deleteSql = "DELETE FROM coordinador e WHERE e.id = "+id;

        try(Connection conn = sql2o.open()){

            Coordinador tupla = conn.createQuery("SELECT * FROM coordinador where id = :idE")
                    .addParameter("idE", id)
                    .executeAndFetchFirst(Coordinador.class);
            if(tupla == null){
                return ("No existe el coordinador con id: " + id);
            }

            conn.createQuery(deleteSql)
                    .executeUpdate();
            return "Se ha eliminado el coordinador "+id;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public Coordinador findOneByEmail(String email) {
        String sql = "SELECT * FROM coordinador WHERE correo_electronico = :email";
        Connection conn = sql2o.open();
        return conn.createQuery(sql)
            .addParameter("email", email)
            .executeAndFetchFirst(Coordinador.class);
    }




}