package com.example.SBD1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import java.util.List;
import java.util.Map;

@RestController
public class routes {

    @Autowired
    private OracleDao oracleDao;



    @GetMapping("/eliminarTemporal")
    public void eliminarTabla() {
        oracleDao.EliminarTT();}

    @GetMapping("/cargarModelo")
    public void cargarModelo(){
        oracleDao.createTableHospital();
        oracleDao.createTableVictima();
        oracleDao.createTableAllegado();
        oracleDao.createTableTipoContacto();
        oracleDao.createTableTratamiento();
        oracleDao.createTableContacto();
        oracleDao.createTableVictimaTratamiento();
        oracleDao.insertModel();
        oracleDao.insertModelVictima();
        oracleDao.insertModelAllegado();
        oracleDao.inserModelTipoContacto();
        oracleDao.insertModelContacto();
        oracleDao.insertModelTratamiento();
        oracleDao.insertModelVictimaTratamiento();
    }

    @GetMapping("/consulta1")
    public List<Map<String, Object>> getHospitalsWithDeaths() {
        return oracleDao.findHospitalsWithDeaths();
    }

    @GetMapping("/consulta2")
    public List<Map<String, Object>> getTratamientoVictima() {
        return oracleDao.CuarentenaEfectividad();
    }

    @GetMapping("/consulta3")
    public List<Map<String, Object>> getAllegadoComunVictima() {
        return oracleDao.AllegadoComunVictima();
    }

    @GetMapping("/consulta4")
    public List<Map<String, Object>> getVictimaEstadoSuspendida() {
        return oracleDao.VicticaSuspendida();
    }

    @GetMapping("/consulta5")
    public List<Map<String, Object>> getOxigeno() {
        return oracleDao.TratamientoOxigeno();
    }

    @GetMapping("/consulta6")
    public List<Map<String, Object>> delphinewell() {
        return oracleDao.DelphineWell();
    }


    @GetMapping("/consulta8")
    public List<Map<String, Object>> superConsulta() {
        return oracleDao.SuperConsulta();
    }

    @GetMapping("/consulta9")
    public List<Map<String, Object>> PorcentajeVictima() {
        return oracleDao.Porcentaje();
    }

    @GetMapping("/consulta10")
    public List<Map<String, Object>> PorcentajeContacto() {
        return oracleDao.PorcentajeContacto();
    }

    @GetMapping("/eliminarModelo")
    public void EliminarModelo(){
        oracleDao.eliminarModelo();
    }


    @GetMapping("/cargarTemporal")
    public String ejecutarBat() {
        oracleDao.createTable();
        try {
            Runtime.getRuntime().exec("cmd /c start C:\\Users\\aller\\Desktop\\SBD1_PROYECTO1_201800992\\Ejecutor.bat");
            return "Archivo .sh ejecutado correctamente.";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al ejecutar archivo .sh: " + e.getMessage();
        }
    }


}

