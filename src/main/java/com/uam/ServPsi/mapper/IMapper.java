package com.uam.ServPsi.mapper;
//El mapper recibe un dato de entrada y uno de salida
//Este mapper es generico, se puede usar para varias entidades
public interface IMapper <I,O>{
    public O map(I in); //Mappea todo lo que entre
}
