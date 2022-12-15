package by.rates.nbrb.api.response;

import lombok.Data;

import java.util.Objects;

@Data
public class CurrencyInfo {
    private Long curId;
    private String date;
    private String curAbbreviation;
    private Long curScale;
    private String curName;
    private Double curOfficialRate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyInfo that = (CurrencyInfo) o;
        return curId.equals(that.curId) && date.equals(that.date) && curAbbreviation.equals(that.curAbbreviation) && curScale.equals(that.curScale) && curName.equals(that.curName) && curOfficialRate.equals(that.curOfficialRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(curId, date, curAbbreviation, curScale, curName, curOfficialRate);
    }
}
