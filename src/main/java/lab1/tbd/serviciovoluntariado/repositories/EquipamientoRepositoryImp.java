package lab1.tbd.serviciovoluntariado.repositories;
import lab1.tbd.serviciovoluntariado.models.Equipamiento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
@Repository

public class EquipamientoRepositoryImp implements EquipamientoRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public Long getIdEquipamientoMayor(){
        try (Connection conn=sql2o.open() ){
            Equipamiento aux=conn.createQuery("SELECT * FROM equipamiento ORDER BY id DESC ")
                    .executeAndFetchFirst(Equipamiento.class);
            if (aux==null){
                return 0L;
            }
            else{
                return aux.getId();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return 0L;
        }
    }


    @Override
    public String createEquipamiento(Equipamiento equipamiento){
        String create="INSERT INTO equipamiento(id,nombre,descripcion,id_voluntario)"+
                "VALUES(:id,:nombre,:descripcion,:id_voluntario)";
        Long nuevoId=getIdEquipamientoMayor()+1;
        try (Connection conn=sql2o.open()){
            conn.createQuery(create)
                    .addParameter("id",nuevoId)
                    .addParameter("nombre",equipamiento.getNombre())
                    .addParameter("descripcion",equipamiento.getDescripcion())
                    .addParameter("id_voluntario",equipamiento.getId_voluntario())
                    .executeUpdate();
            return "Se ha creado el equipamiento: "+nuevoId;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Equipamiento> getAllEquipamiento(){
        String getAll="SELECT * FROM equipamiento";
        try (Connection conn=sql2o.open()){
            return conn.createQuery(getAll).executeAndFetch(Equipamiento.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Equipamiento getEquipamientoById(Long id){
        String get="SELECT * FROM equipamiento WHERE id=:eid";
        try (Connection conn=sql2o.open()){
            return conn.createQuery(get)
                    .addParameter("eid",id)
                    .executeAndFetchFirst(Equipamiento.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }


    public String updateEquipamiento(Long id,Equipamiento equipamiento){
        String update="UPDATE equipamiento "+
                "SET nombre = :nombreEquipamiento, descripcion = :descripcionEquipamiento, id_voluntario = :voluntarioEquipamiento, updated_at=:fechaActualizacion "+
                "WHERE id=:equipamientoId";
        Date date=new Date();
        Timestamp timestamp=new Timestamp(date.getTime());

        try(Connection conn=sql2o.open()) {
            Equipamiento equipamientoEncontrado= conn.createQuery("SELECT * FROM EQUIPAMIENTO WHERE id=:id")
                    .addParameter("id",id)
                    .executeAndFetchFirst(Equipamiento.class);
            if (equipamientoEncontrado==null){
                return "No se ha encontrado el equipamiento con id: "+id;
            }
            else {
                Query consulta= conn.createQuery(update);
                consulta.addParameter("equipamientoId",id);
                if (equipamiento.getNombre()!=null){
                    consulta.addParameter("nombreEquipamiento",equipamiento.getNombre());
                }
                else {
                    consulta.addParameter("nombreEquipamiento",equipamientoEncontrado.getNombre());
                }
                if (equipamiento.getDescripcion()!=null){
                    consulta.addParameter("descripcionEquipamiento",equipamiento.getDescripcion());
                }
                else {
                    consulta.addParameter("descripcionEquipamiento",equipamientoEncontrado.getDescripcion());
                }
                if (equipamiento.getId_voluntario()!=null){
                    consulta.addParameter("voluntarioEquipamiento",equipamiento.getId_voluntario());
                }
                else{
                    consulta.addParameter("voluntarioEquipamiento",equipamientoEncontrado.getId_voluntario());
                }
                consulta.addParameter("fechaActualizacion",timestamp);
                consulta.executeUpdate();
                return "El equipamiento "+ id+" ha sido actualizado correctamente";
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "No se ha podido actualizar el equipamiento con id: "+id;
        }

    }

    public String deleteEquipamiento(Long id){
        String delete="DELETE FROM equipamiento e WHERE e.id="+id;
        try (Connection conn=sql2o.open()){
            Equipamiento equipamientoEliminar=conn.createQuery("SELECT * FROM equipamiento WHERE id =:eid")
                    .addParameter("eid",id)
                    .executeAndFetchFirst(Equipamiento.class);
            if (equipamientoEliminar==null){
                return "No se ha encontrado el equipamiento don id: "+id;
            }
            conn.createQuery(delete).executeUpdate();
            return "Se ha eliminado el equipamiento con id: "+id;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }


}