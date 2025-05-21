package co.edu.uniquindio.poo.model;

import java.util.*;

public class Hospital {

    private ArrayList<Administrador> listAdministradores;
    private ArrayList<Medico> listMedicos;
    private ArrayList<Paciente> listPacientes;
    private ArrayList<Usuario> listUsuarios;

    public Hospital(){

        this.listAdministradores=new ArrayList<>();
        this.listMedicos=new ArrayList<>();
        this.listPacientes=new ArrayList<>();
        this.listUsuarios=new ArrayList<>();
    }

    public ArrayList<Administrador> getListAdministradores() {
        return listAdministradores;
    }

    public void setListAdministradores(ArrayList<Administrador> listAdministradores) {
        this.listAdministradores = listAdministradores;
    }

    public ArrayList<Medico> getListMedicos() {
        return listMedicos;
    }

    public void setListMedicos(ArrayList<Medico> listMedicos) {
        this.listMedicos = listMedicos;
    }

    public ArrayList<Paciente> getListPacientes() {
        return listPacientes;
    }

    public void setListPacientes(ArrayList<Paciente> listPacientes) {
        this.listPacientes = listPacientes;
    }

    public ArrayList<Usuario> getListUsuarios() {
        return listUsuarios;
    }

    public void setListUsuarios(ArrayList<Usuario> listUsuarios) {
        this.listUsuarios = listUsuarios;
    }

}