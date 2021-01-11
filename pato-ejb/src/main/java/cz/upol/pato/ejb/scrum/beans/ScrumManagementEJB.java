package cz.upol.pato.ejb.scrum.beans;

import cz.upol.pato.ejb.scrum.api.ScrumManagementEJBLocal;

import java.util.List;
import java.util.Map;

public class ScrumManagementEJB implements ScrumManagementEJBLocal {


    @Override
    public void createScrum(long project, Map<String, List<String>> columnNamesTicketStatesMap) {
        //TODO
    }

    @Override
    public String getScrumTableForProject(long project) {
        //TODO
        return null;
    }

    @Override
    public String getAllScrumsForUserProjects(long userId) {
        //TODO
        return null;
    }
}
