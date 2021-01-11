package cz.upol.pato.ejb.scrum.api;

import java.util.List;
import java.util.Map;

public interface ScrumManagementEJBLocal {

    void createScrum (long project, Map<String, List<String>> columnNamesTicketStatesMap);

    String getScrumTableForProject (long project);

    String getAllScrumsForUserProjects (long userId);
}
