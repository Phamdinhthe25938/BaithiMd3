USE databaithimd3;

Create table phong(
    idPhong int primary key,
    namePhong varchar(50)
);

Create table Staff(
    idStaff int primary key,
    nameStaff varchar(50) not null,
    dateStaff Date not null,
    addressStaff varchar(50) not null,
    emailStaff varchar(50) not null,
    phoneNumber varchar(50) not null,
    idPhong int,
    foreign key (idPhong) references phong(idPhong)
);