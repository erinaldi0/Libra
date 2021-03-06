package it.unisa.libra.model.jpa;

import it.unisa.libra.bean.Report;
import it.unisa.libra.bean.ReportPK;
import it.unisa.libra.model.dao.IReportDao;
import it.unisa.libra.util.Loggable;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

@Stateless
@Loggable
public class ReportJpa extends GenericJpa<Report, ReportPK> implements IReportDao {

  @Override
  public Long getNumReports() {
    TypedQuery<Long> query = entityManager.createNamedQuery("Report.countAll", Long.class);
    return query.getSingleResult();
  }

}
