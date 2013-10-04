package com.fpmislata.daw2.banco.negocio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CuentaBancaria {

    private int idCuentaBancaria;
    private SucursalBancaria sucursalBancaria;
    private String numeroCuenta;
    private String dc;
    private BigDecimal saldo;
    private String cif;
    List<MovimientoBancario> movimientosBancarios = new ArrayList<>();

    public CuentaBancaria(int idCuentaBancaria, SucursalBancaria sucursalBancaria, String numeroCuenta, String dc, BigDecimal saldo, String cif) {
        this.idCuentaBancaria = idCuentaBancaria;
        this.sucursalBancaria = sucursalBancaria;
        this.numeroCuenta = numeroCuenta;
        this.dc = dc;
        this.saldo = saldo;
        this.cif = cif;
    }

    public int getIdCuentaBancaria() {
        return idCuentaBancaria;
    }

    public void setIdCuentaBancaria(int idCuentaBancaria) {
        this.idCuentaBancaria = idCuentaBancaria;
    }

    public SucursalBancaria getSucursalBancaria() {
        return sucursalBancaria;
    }

    public void setSucursalBancaria(SucursalBancaria sucursalBancaria) {
        this.sucursalBancaria = sucursalBancaria;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getDc() {
        return dc;
    }

    public void setDc(String dc) {
        this.dc = dc;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public List<MovimientoBancario> getMovimientosBancarios() {
        return movimientosBancarios;
    }

    public void setMovimientosBancarios(List<MovimientoBancario> movimientosBancarios) {
        this.movimientosBancarios = movimientosBancarios;
    }
}
