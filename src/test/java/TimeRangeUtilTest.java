import static org.junit.Assert.assertEquals;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.junit.Test;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;

public class TimeRangeUtilTest {

	@Test
	public void minusTest() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		
		Range<LocalTime> r1 = Range.closed(LocalTime.parse("09:00", formatter), LocalTime.parse("10:00", formatter));
		Range<LocalTime> r2 = Range.closed(LocalTime.parse("09:00", formatter), LocalTime.parse("09:30", formatter));
		
		RangeSet<LocalTime> result = TimeRangeUtil.minus(Arrays.asList(r1), Arrays.asList(r2));
		
		System.out.println(result);		
		assertEquals( 1, result.asRanges().size());
	}
	
	@Test
	public void minusTestInTheMiddle() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		
		Range<LocalTime> r1 = Range.closed(LocalTime.parse("09:00", formatter), LocalTime.parse("10:00", formatter));
		Range<LocalTime> r2 = Range.closed(LocalTime.parse("09:10", formatter), LocalTime.parse("09:30", formatter));
		
		RangeSet<LocalTime> result = TimeRangeUtil.minus(Arrays.asList(r1), Arrays.asList(r2));
		
		System.out.println(result);		
		assertEquals( 2, result.asRanges().size());
	}

}
