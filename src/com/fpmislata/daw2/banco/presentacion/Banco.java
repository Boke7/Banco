package com.fpmislata.daw2.banco.presentacion;

import com.fpmislata.daw2.banco.datos.EntidadBancariaDAO;
import com.fpmislata.daw2.banco.negocio.EntidadBancaria;
import com.fpmislata.daw2.banco.negocio.TipoEntidadBancaria;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Banco {
        
    public static void main(String[] args) throws SQLException {

SessionFactory sessionFactory;
Configuration configuration = new Configuration();
configuration.configure();
ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
sessionFactory = configuration.buildSessionFactory(serviceRegistry);

Session session = sessionFactory.openSession();
        /*EntidadBancariaDAO eDAO = new EntidadBancariaDAO();

         /*BigDecimal saldo1 = new BigDecimal("512.25");
         BigDecimal saldo2 = new BigDecimal("1502.35");
         BigDecimal importe1 = new BigDecimal("40");
         BigDecimal importe2 = new BigDecimal("100");
         BigDecimal importe3 = new BigDecimal("150");
         BigDecimal importe4 = new BigDecimal("200");
         BigDecimal saldoTotal1 = new BigDecimal("552");
         BigDecimal saldoTotal2 = new BigDecimal("1602");
         BigDecimal saldoTotal3 = new BigDecimal("2000");
         BigDecimal saldoTotal4 = new BigDecimal("1300");

         Date fecha1 = (new GregorianCalendar(2009, 9, 2)).getTime();
         Date fecha2 = (new GregorianCalendar(2010, 10, 25)).getTime();
         Date fecha3 = (new GregorianCalendar(2011, 1, 6)).getTime();
         Date fecha4 = (new GregorianCalendar(2012, 5, 17)).getTime();


         */EntidadBancaria entidad1 = new EntidadBancaria(2, "004", "Banco Daniel", "53758419J");
        /*EntidadBancaria entidad2 = new EntidadBancaria(2, "012", "Caja Rural Torrent", "53535353J", TipoEntidadBancaria.CAJA_AHORRO);

         SucursalBancaria sucursal1 = new SucursalBancaria(1, entidad1, "125", "Sucursal de Valencia");
         SucursalBancaria sucursal2 = new SucursalBancaria(2, entidad1, "078", "Sucursal de Torrent");

         CuentaBancaria cuenta1 = new CuentaBancaria(1, sucursal1, "1234", "02", saldo1, "55555555M");
         CuentaBancaria cuenta2 = new CuentaBancaria(2, sucursal1, "4321", "15", saldo2, "44444444L");

         MovimientoBancario movimiento1 = new MovimientoBancario(1, TipoMovimientoBancario.HABER, importe1, fecha1, saldoTotal1, "Ingreso " + importe1 + " €",cuenta1);
         MovimientoBancario movimiento2 = new MovimientoBancario(2, TipoMovimientoBancario.HABER, importe2, fecha2, saldoTotal2, "Ingreso " + importe2 + " €",cuenta2);
         MovimientoBancario movimiento3 = new MovimientoBancario(3, TipoMovimientoBancario.DEBE, importe3, fecha3, saldoTotal3, "Pago de " + importe3 + " €",cuenta1);
         MovimientoBancario movimiento4 = new MovimientoBancario(4, TipoMovimientoBancario.DEBE, importe4, fecha4, saldoTotal4, "Pago de " + importe4 + " €",cuenta2);

         List<SucursalBancaria> sucursalesBancarias = entidad1.getSucursales();
         sucursalesBancarias.add(sucursal1);
         sucursalesBancarias.add(sucursal2);

         List<CuentaBancaria> cuentasBancarias = sucursal1.getCuentas();
         cuentasBancarias.add(cuenta1);
         cuentasBancarias.add(cuenta2);

         List<MovimientoBancario> movimientosBancarios1 = cuenta1.getMovimientosBancarios();
         movimientosBancarios1.add(movimiento1);
         movimientosBancarios1.add(movimiento2);
        
         List<MovimientoBancario> movimientosBancarios2 = cuenta2.getMovimientosBancarios();
         movimientosBancarios2.add(movimiento3);
         movimientosBancarios2.add(movimiento4);
         imprimirMovimientos(cuenta1);

         }

         public static void imprimirMovimientos(CuentaBancaria cuentaBancaria) {
        
         String codigoEntidadBancaria = cuentaBancaria.getSucursalBancaria().getEntidadBancaria().getCodigoEntidad();
         String codigoSucursalBancaria = cuentaBancaria.getSucursalBancaria().getCodigoSucursal();
         String codigoCuentaBancaria = cuentaBancaria.getNumeroCuenta();
         System.out.println(codigoEntidadBancaria+" "+codigoSucursalBancaria+" "+cuentaBancaria.getDc()+" "+codigoCuentaBancaria);
         for(MovimientoBancario movimientoBancario:cuentaBancaria.getMovimientosBancarios()){ 
         System.out.println(movimientoBancario.getIdMovimientoBancario()+" "+movimientoBancario.getTipoMovimientoBancario()+" "+movimientoBancario.getImporte()+" "+movimientoBancario.getFecha()+" "+movimientoBancario.getSaldoTotal()+" "+movimientoBancario.getConcepto());   
         }*/


        /*eDAO.insert(entidad1);*/

        /*eDAO.update(entidad1);*/

        /*eDAO.delete(5);*/

        /*eDAO.read(5);*/

        /*System.out.println(eDAO.read(5).getIdEntidadBancaria()+" "+eDAO.read(5).getCodigoEntidad()+" "+eDAO.read(5).getCif()+" "+eDAO.read(5).getNombre()+" "+eDAO.read(5).getTipoEntidadBancaria());
        
         for(EntidadBancaria entidadBancaria:eDAO.findByCodigo("005")){
            
         System.out.println(entidadBancaria.getIdEntidadBancaria() + " " + entidadBancaria.getCodigoEntidad() + " " + entidadBancaria.getNombre() + " " + entidadBancaria.getCif() + " " + entidadBancaria.getTipoEntidadBancaria());
            
         }
        
         for(EntidadBancaria entidadBancaria:eDAO.findAll()){
            
         System.out.println(entidadBancaria.getIdEntidadBancaria() + " " + entidadBancaria.getCodigoEntidad() + " " + entidadBancaria.getNombre() + " " + entidadBancaria.getCif() + " " + entidadBancaria.getTipoEntidadBancaria());
            
         }*/

        session.beginTransaction();
 
        session.save(entidad1); //<|--- Aqui guardamos el objeto en la base de datos.
 
        session.getTransaction().commit();
        session.close();    

    }
}
