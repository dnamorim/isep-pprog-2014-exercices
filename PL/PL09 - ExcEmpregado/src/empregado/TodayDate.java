/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package empregado;

import java.util.Calendar;
import utilitarios.Data;

/**
 *
 * @author Duarte Nuno Amorim <1130674@isep.ipp.pt>
 */
public class TodayDate {

    public static Data dataActual() {
        Calendar hoje = Calendar.getInstance();
        int ano = hoje.get(Calendar.YEAR);
        int mes = hoje.get(Calendar.MONTH) + 1; 
        int dia = hoje.get(Calendar.DAY_OF_MONTH);
        return new Data(ano, mes, dia);
       
    }
}
