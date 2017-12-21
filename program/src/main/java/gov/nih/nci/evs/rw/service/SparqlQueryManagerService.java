package gov.nih.nci.evs.rw.service;

import java.util.List;

import gov.nih.nci.evs.rw.model.evs.EvsAxiom;
import gov.nih.nci.evs.rw.model.evs.EvsConcept;
import gov.nih.nci.evs.rw.model.evs.EvsProperty;
import gov.nih.nci.evs.rw.model.evs.EvsSubclass;
import gov.nih.nci.evs.rw.model.evs.EvsSuperclass;

public interface SparqlQueryManagerService {

	public String getEvsConceptLabel(String conceptCode);
	
	public List <EvsProperty> getEvsProperties(String conceptCode);
	
	public List<EvsAxiom> getEvsAxioms(String conceptCode);
	
	public List<EvsConcept> getEvsSubclasses(String conceptCode);
	
	public List<EvsConcept> getEvsSuperclasses(String conceptCode);
	
	public EvsConcept getEvsConceptDetail(String conceptCode);

	public EvsConcept getEvsConceptDetailShort(String conceptCode);

	public List <EvsConcept> getEvsConceptInSubset(String conceptCode);
	
	public String getNamedGraph();
}