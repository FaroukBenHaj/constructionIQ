package tn.esprit.hseservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.hseservice.entity.Incident;
import tn.esprit.hseservice.repository.IncidentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class IncidentServiceImpl implements IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;

    @Override
    public Incident createIncident(Incident incident) {
        return incidentRepository.save(incident);
    }

    @Override
    public Incident updateIncident(Long id, Incident incident) {
        Optional<Incident> optionalIncident = incidentRepository.findById(id);
        if(optionalIncident.isPresent()){
            incident.setIncidentID(id);
            return incidentRepository.save(incident);
        } else {
            throw new RuntimeException("Incident non trouvé avec l'id " + id);
        }
    }

    @Override
    public void deleteIncident(Long id) {
        incidentRepository.deleteById(id);
    }

    @Override
    public Incident getIncidentById(Long id) {
        return incidentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Incident non trouvé avec l'id " + id));
    }

    @Override
    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }
}
