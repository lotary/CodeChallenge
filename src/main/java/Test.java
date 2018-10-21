import java.util.Date;
import java.util.GregorianCalendar;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Interval;
import org.joda.time.Months;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;

public class Test {

	public static void main(String[] args) {

		/*
		 * 
		Examples: 
			 
			(9:00-10:00) “minus” (9:00-9:30) = (9:30-10:00) 
			 
			(9:00-10:00) “minus” (9:00-10:00) = () 
			 
			(9:00-9:30) “minus” (9:30-15:00) = (9:00-9:30) 
			 
			(9:00-9:30, 10:00-10:30) “minus” (9:15-10:15) = (9:00-9:15, 10:15-10:30) 
			 
			(9:00-11:00, 13:00-15:00) “minus” (9:00-9:15, 10:00-10:15, 12:30-16:00) = (9:15-10:00, 10:15-11:00) 
			 
		*/	 
	
	        DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");
	        DateTime start1 = formatter.parseDateTime("9:00");
	        DateTime end1 = formatter.parseDateTime("9:30");
	        Range<DateTime> e = Range.closed(start1, end1);

	        DateTime start3 = formatter.parseDateTime("10:00");
	        DateTime end3 = formatter.parseDateTime("10:30");
	        Range<DateTime> a = Range.closed(start3, end3);
	        
	        DateTime start2 = formatter.parseDateTime("09:15");
	        DateTime end2 = formatter.parseDateTime("10:15");
	        Range<DateTime> f = Range.closed(start2, end2);
	        
			RangeSet<DateTime> result1 = TreeRangeSet.create();
			result1.add(e);
			result1.add(a);
			result1.remove(f);
			
			for(Range<DateTime> r: result1.asRanges()) {
				System.out.println( formatter.print( r.lowerEndpoint()) +"-" + formatter.print(r.upperEndpoint()));
			}
			
			
			
		/*	
		DateTime startDate = new DateTime();
        DateTime endDate = startDate.plus(Months.months(2));

        // Creates an interval from a start to an end instant.
        Interval interval = new Interval(startDate, endDate);
        System.out.println("Interval = " + interval);
        System.out.println("Start    = " + interval.getStart());
        System.out.println("End      = " + interval.getEnd());

        System.out.println("Days     = " + interval.toDuration().getStandardDays());
        System.out.println("Hours    = " + interval.toDuration().getStandardHours());
        System.out.println("Minutes  = " + interval.toDuration().getStandardMinutes());
        System.out.println("Seconds  = " + interval.toDuration().getStandardSeconds());

        // Add one more month to the interval
        interval = interval.withEnd(interval.getEnd().plusMonths(1));
        System.out.println("Interval = " + interval);

        // Gets the duration of this time interval
        Duration duration = interval.toDuration();
        System.out.println("Duration = " + duration);
        System.out.println("Days     = " + duration.getStandardDays());
        System.out.println("Hours    = " + duration.getStandardHours());
        System.out.println("Minutes  = " + duration.getStandardMinutes());
        System.out.println("Seconds  = " + duration.getStandardSeconds());
        
        Interval i1 = new Interval(9, 11);
        Interval i2 = new Interval(10, 12);
        
        System.out.println(i1.overlap(i2));
        
      
        DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");
        DateTime start1 = formatter.parseDateTime("9:00");
        DateTime end1 = formatter.parseDateTime("10:00");

        Interval int1 = new Interval(start1, end1);
        System.out.println("int1   " + formatter.print(int1.getStart()));
        
        DateTime start2 = formatter.parseDateTime("09:00");
        DateTime end2 = formatter.parseDateTime("9:30");
        
        Interval int2 = new Interval(start2, end2);
        System.out.println("int2   " + int2.toString());
        Interval overlap = int1.overlap(int2);
        System.out.println( "overlap :  Start " + formatter.print(overlap.getStart()) + " - " + formatter.print(overlap.getEnd()));
        */
	}
	
	static String sumTimes(String time1, String time2) {
	    PeriodFormatter formatter = new PeriodFormatterBuilder()
	            .minimumPrintedDigits(2)
	            .printZeroAlways()
	            .appendHours()
	            .appendLiteral(":")
	            .appendMinutes()
	            .toFormatter();

	    Period period1 = formatter.parsePeriod(time1);
	    Period period2 = formatter.parsePeriod(time2);
	    return formatter.print(period1.plus(period2));
	}

}
