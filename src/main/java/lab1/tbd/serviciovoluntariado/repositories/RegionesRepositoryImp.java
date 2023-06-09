package lab1.tbd.serviciovoluntariado.repositories;

import lab1.tbd.serviciovoluntariado.models.Regiones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.Map;

@Repository
public class RegionesRepositoryImp implements RegionesRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Regiones> getAllRegiones() {
        final String sql =
                "SELECT gid, nom_reg FROM division_regional";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .executeAndFetch(Regiones.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Map<String, Object>> getRegionPoly(Long id) {
        final String sql =
                "SELECT array_to_string(array_agg, ',') FROM \n" +
                        "(SELECT array_agg( ST_x(geom)||' '||ST_y(geom))  FROM \n" +
                        "    (SELECT (ST_dumppoints(geom)).geom FROM division_Regional\n" +
                        "    where division_Regional.gid= :tid\n" +
                        "    ) AS foo_1\n" +
                        ") AS foo_2;";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .addParameter("tid", id)
                    .executeAndFetchTable().asList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}