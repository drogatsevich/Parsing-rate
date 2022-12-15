package by.rates.nbrb.api.response;

import lombok.Data;

@Data
public class CurrencyRateResponse {
    private Long curId;
    private String date;
    private String curAbbreviation;
    private Long curScale;
    private String curName;
    private Double curOfficialRate;
    private String courseChanges;

    @Override
    public String toString() {
        return "CurrencyRateResponse{" +
                "curId=" + curId +
                ", date='" + date + '\'' +
                ", curAbbreviation='" + curAbbreviation + '\'' +
                ", curScale=" + curScale +
                ", curName='" + curName + '\'' +
                ", curOfficialRate=" + curOfficialRate +
                ", courseChanges='" + courseChanges + '\'' +
                '}';
    }
}
