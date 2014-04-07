import java.util.Date;


public class utilities {
	public static Integer getMonthsBetween(Date startDate,Date endDate)
	{
	int diffYear = endDate.getYear()-startDate.getYear() ;
	int diffMonth = diffYear * 12 +  endDate.getMonth()+1-startDate.getMonth() ;
	return diffMonth;
	}
}
