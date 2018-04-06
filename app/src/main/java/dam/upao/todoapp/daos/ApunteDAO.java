package dam.upao.todoapp.daos;

import java.util.ArrayList;

import dam.upao.todoapp.models.Apunte;

/**
 * Created by Upao on 05/04/2018.
 */

public class ApunteDAO {
    public static ArrayList<Apunte> all = new ArrayList<>();
    public static void save (Apunte apunte) {
        all.add(apunte);
    }
}
