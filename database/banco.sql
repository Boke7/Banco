CREATE TABLE EntidadBancaria(
	idEntidad int PRIMARY KEY,
	codigoEntidad varchar(10),
	nombre varchar(40),
	cif varchar(15),
	tipoEntidadBancaria varchar(50)
);

CREATE TABLE SucursalBancaria(
idSucursalBancaria int PRIMARY KEY, 
entidadBancaria int,
codigoSucursal varchar(10),
nombre varchar(40),
foreign key SucursalBancaria(entidadBancaria) REFERENCES EntidadBancaria(idEntidad)
);

CREATE TABLE CuentaBancaria( 
idCuentaBancaria int PRIMARY KEY,
sucursalBancaria int, 
numeroCuenta varchar(20),
dc varchar(5), 
saldo decimal(10,2),
cif varchar(10),
foreign key CuentaBancaria(sucursalBancaria) REFERENCES SucursalBancaria(idSucursalBancaria)
);

CREATE TABLE MovimientoBancario(
idMovimientoBancario int PRIMARY KEY,
tipoMovimientoBancario varchar(15),
importe DECIMAL(10,2), 
fecha DATE,
saldoTotal DECIMAL(10,2), 
concepto VARCHAR(30)
);