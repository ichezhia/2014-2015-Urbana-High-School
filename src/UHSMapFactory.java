public class UHSMapFactory {
	public enum MapType {CAMPUS, FIRST_FLOOR, SECOND_FLOOR};
	
	public static UHSMap createUHSMap(String mapName) {
		
	UHSMap retVal = null;
		
	if (mapName.toLowerCase().equals("campus")) {
		retVal = new UHSCampusMap();
		} else if (mapName.toLowerCase().equals("first floor")) {
			retVal = new UHSFirstFloorMap();
		} else if (mapName.toLowerCase().equals("second floor")) {
			retVal = new UHSSecondFloorMap();
		}
		return retVal;
	}
	
	public static UHSMap create(MapType type) {
		
		UHSMap retVal = null;
		
		if (type == MapType. CAMPUS) {
			retVal = new UHSCampusMap();
		} else if ( type == MapType.FIRST_FLOOR) {
			retVal = new UHSFirstFloorMap();
		} else if (type == MapType.SECOND_FLOOR) {
			retVal = new UHSSecondFloorMap();
		}
		return retVal;
	}
}

