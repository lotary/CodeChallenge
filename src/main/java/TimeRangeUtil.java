import java.time.LocalTime;
import java.util.List;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;

public class TimeRangeUtil {

	public static RangeSet<LocalTime> minus(List<Range<LocalTime>> a, List<Range<LocalTime>> b){
		
		
		RangeSet<LocalTime> result = TreeRangeSet.create();
		for(Range<LocalTime> r: a)
			result.add(r);
		for(Range<LocalTime> r: b)
			result.remove(r);
		
		return result;
	}
}
