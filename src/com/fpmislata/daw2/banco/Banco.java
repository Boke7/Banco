package com.fpmislata.daw2.banco;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Banco {

    public static void main(String[] args) {
        
        BigDecimal saldo1 = new BigDecimal("512.25");
        BigDecimal saldo2 = new BigDecimal("1502.35");
        BigDecimal importe1 = new BigDecimal("40");
        BigDecimal importe2 = new BigDecimal("100");
        BigDecimal saldoTotal1= new BigDecimal("552");
        BigDecimal saldoTotal2= new BigDecimal("1602");
        
        Date fecha = new Date();
        
        
        EntidadBancaria entidad1 = new EntidadBancaria(1, "005", "Banco Santander", "53758419J", TipoEntidadBancaria.BANCO);
        EntidadBancaria entidad2 = new EntidadBancaria(2, "012", "Caja Rural Torrent", "53535353J", TipoEntidadBancaria.CAJA_AHORRO);
        
        SucursalBancaria sucursal1 = new SucursalBancaria(1, entidad1, "125", "Sucursal de Valencia");
        SucursalBancaria sucursal2 = new SucursalBancaria(2, entidad1, "078", "Sucursal de Torrent");
        
        CuentaBancaria cuenta1 = new CuentaBancaria(1, sucursal1,"1234", "02", saldo1, "55555555M");
        CuentaBancaria cuenta2 = new CuentaBancaria(2, sucursal1,"4321", "15", saldo2, "44444444L");
        
        MovimientoBancario movimiento1 = new MovimientoBancario(1, TipoMovimientoBancario.HABER, importe1,fecha, saldoTotal1, "Ingreso 40€");
    }
}
