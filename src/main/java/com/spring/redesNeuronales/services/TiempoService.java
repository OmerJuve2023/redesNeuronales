package com.spring.redesNeuronales.services;

import com.opencsv.CSVWriter;
import com.spring.redesNeuronales.models.Tiempo;
import com.spring.redesNeuronales.repositories.TiempoRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TiempoService {
    private final TiempoRepository repository;

    public void addTiempo(Tiempo tiempo) {
        repository.save(tiempo);
    }

    public void writeCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"tiempos.csv\"");

        CSVWriter csvWriter = new CSVWriter(response.getWriter());
        List<Tiempo> tiempos = repository.findAll();
        String[] encabezados = {"Codigo", "Clave", "T1", "T2", "T3", "T4", "T5", "T6", "T7", "Fecha"};
        csvWriter.writeNext(encabezados);
        for (Tiempo tiempo : tiempos) {
            String[] linea = new String[]{tiempo.getCodigo().toString(),
                    tiempo.getClave(), tiempo.getT1(), tiempo.getT2(), tiempo.getT3(),
                    tiempo.getT4(), tiempo.getT5(), tiempo.getT6(), tiempo.getT7()};
            csvWriter.writeNext(linea);
        }
        csvWriter.close();
    }

    public List<Tiempo> getListTiempo() {
        return repository.findAll();
    }
}
