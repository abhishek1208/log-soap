import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

class MyFormatter extends Formatter{

		@Override
		public String format(LogRecord record) {
			// TODO Auto-generated method stub
			SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
		    Date now = new Date();
		    String strDate = sdfDate.format(now);
			StringBuilder sb = new StringBuilder();
	        sb.append(strDate).append(':');
	        sb.append(record.getLevel()).append('\n');
	        sb.append(record.getMessage()).append('\n');
	        return sb.toString();
		}

	}
