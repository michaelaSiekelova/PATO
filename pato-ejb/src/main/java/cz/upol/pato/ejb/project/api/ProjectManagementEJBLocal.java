package cz.upol.pato.ejb.project.api;

import cz.upol.pato.ejb.project.entity.Project;

public interface ProjectManagementEJBLocal {

    String getAllProjectsForUser(long userId);

    String createProject(String name, String key);

    String getProjectDetail(long id);

    Project getProject(long id);
}
