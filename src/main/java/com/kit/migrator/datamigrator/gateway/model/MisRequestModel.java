package com.kit.migrator.datamigrator.gateway.model;

import com.kit.migrator.datamigrator.Utility.Utils;
import com.kit.migrator.datamigrator.dto.AlternateDto;
import com.kit.migrator.datamigrator.dto.BeneficiaryDto;
import com.kit.migrator.datamigrator.dto.MisNomineeDto;
import com.kit.migrator.datamigrator.enums.GenderEnum;
import com.kit.migrator.datamigrator.enums.SelectionReasonEnum;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MisRequestModel {

    private String supervisor_id; //
    private String partner_code; // 
    private String household_number;
    private String beneficiary_type; //
    private String group_number; //
    private String member_number; //
    private String household_size;
    private String household_name;
    private String age;
    private String spouse_name;
    private String id_number;
    private String phone_number;
    private String gender;
    private String female_dependants; //
    private String male_dependants; //
    private String zero_five;
    private String six_eighteen;
    private String nineteen_forty_five;
    private String forty_six_sixty_five;
    private String sixty_six;
    private String income_household;
    private String average_household;
    private String state;
    private String county;
    private String payam;
    private String boma;
    private String latitude;
    private String longitude;
    private String legal_status;
    private String photo_url;
    private String status;
    private String created_at;
    private String updated_at;
    private String alternate_number; //
    private String selection_criteria;
    private String selection_reason;
    private String liTemplate;
    private String lmTemplate;
    private String lrTemplate;
    private String lsTemplate;
    private String ltTemplate;
    private String riTemplate;
    private String rmTemplate;
    private String rrTemplate;
    private String rsTemplate;
    private String rtTemplate;

    private String household_photo_url;
    private String alt1_photo_url;
    private String alt2_photo_url;
    private String alt1Name;
    private String alt1Gender;
    private String alt1Age;
    private String alt1Nid;
    private String alt1Mobile;
    private String alt2Name;
    private String alt2Gender;
    private String alt2Age;
    private String alt2Nid;
    private String alt2Mobile;
    
    List<MisNomineeDto> nomineeList;

    public MisRequestModel(BeneficiaryDto dto) {
        this.household_number = dto.getApplicationId();
        this.member_number = dto.getHouseholdSize() != null ? dto.getHouseholdSize().toString() : null;
        this.household_name = dto.getRespondentFirstName() + " " + dto.getRespondentMiddleName() + " " + dto.getRespondentLastName();
        this.age = dto.getRespondentAge() != null ? dto.getRespondentAge().toString() : null;
        this.id_number = dto.getRespondentId();
        this.phone_number = dto.getRespondentPhoneNo();

        if (dto.getSpouseFirstName() != null && dto.getSpouseFirstName().length() > 0) {
            this.spouse_name = dto.getSpouseFirstName() + " " + dto.getSpouseMiddleName() + " " + dto.getSpouseLastName();
        }
        if (dto.getRespondentGender() == GenderEnum.MALE) {
            this.gender = "M";
        }
        if (dto.getRespondentGender() == GenderEnum.FEMALE) {
            this.gender = "F";
        }
        Integer zeroFive = 0;
        Integer maleTotal = 0;
        Integer femaleTotal = 0;
        if (dto.getHouseholdMember2() != null) {
            maleTotal += dto.getHouseholdMember2().getMaleTotal() != null ? dto.getHouseholdMember2().getMaleTotal() : 0;
            femaleTotal += dto.getHouseholdMember2().getFemaleTotal() != null ? dto.getHouseholdMember2().getFemaleTotal() : 0;
            zeroFive = (dto.getHouseholdMember2().getMaleTotal() != null ? dto.getHouseholdMember2().getMaleTotal() : 0)
                    + (dto.getHouseholdMember2().getFemaleTotal() != null ? dto.getHouseholdMember2().getFemaleTotal() : 0);

        }
        if (dto.getHouseholdMember5() != null) {
            maleTotal += dto.getHouseholdMember5().getMaleTotal() != null ? dto.getHouseholdMember5().getMaleTotal() : 0;
            femaleTotal += dto.getHouseholdMember5().getFemaleTotal() != null ? dto.getHouseholdMember5().getFemaleTotal() : 0;

            zeroFive += (dto.getHouseholdMember5().getMaleTotal() != null ? dto.getHouseholdMember5().getMaleTotal() : 0)
                    + (dto.getHouseholdMember5().getFemaleTotal() != null ? dto.getHouseholdMember5().getFemaleTotal() : 0);

        }
        this.zero_five = zeroFive.toString();

        Integer sixEighteen = 0;
        if (dto.getHouseholdMember17() != null) {
            maleTotal += dto.getHouseholdMember17().getMaleTotal() != null ? dto.getHouseholdMember17().getMaleTotal() : 0;
            femaleTotal += dto.getHouseholdMember17().getFemaleTotal() != null ? dto.getHouseholdMember17().getFemaleTotal() : 0;

            sixEighteen = (dto.getHouseholdMember17().getMaleTotal() != null ? dto.getHouseholdMember17().getMaleTotal() : 0)
                    + (dto.getHouseholdMember17().getFemaleTotal() != null ? dto.getHouseholdMember17().getFemaleTotal() : 0);
        }
        this.six_eighteen = sixEighteen.toString();

        Integer nineteenFortyFive = 0;
        if (dto.getHouseholdMember35() != null) {
            maleTotal += dto.getHouseholdMember35().getMaleTotal() != null ? dto.getHouseholdMember35().getMaleTotal() : 0;
            femaleTotal += dto.getHouseholdMember35().getFemaleTotal() != null ? dto.getHouseholdMember35().getFemaleTotal() : 0;

            nineteenFortyFive = (dto.getHouseholdMember35().getMaleTotal() != null ? dto.getHouseholdMember35().getMaleTotal() : 0)
                    + (dto.getHouseholdMember35().getFemaleTotal() != null ? dto.getHouseholdMember35().getFemaleTotal() : 0);
        }
        this.nineteen_forty_five = nineteenFortyFive.toString();

        Integer fortySixSixtyFive = 0;
        if (dto.getHouseholdMember64() != null) {
            maleTotal += dto.getHouseholdMember64().getMaleTotal() != null ? dto.getHouseholdMember64().getMaleTotal() : 0;
            femaleTotal += dto.getHouseholdMember64().getFemaleTotal() != null ? dto.getHouseholdMember64().getFemaleTotal() : 0;

            fortySixSixtyFive = (dto.getHouseholdMember64().getMaleTotal() != null ? dto.getHouseholdMember64().getMaleTotal() : 0)
                    + (dto.getHouseholdMember64().getFemaleTotal() != null ? dto.getHouseholdMember64().getFemaleTotal() : 0);
            this.forty_six_sixty_five = fortySixSixtyFive.toString();
        }

        Integer sixtySix = 0;
        if (dto.getHouseholdMember65() != null) {
            maleTotal += dto.getHouseholdMember65().getMaleTotal() != null ? dto.getHouseholdMember65().getMaleTotal() : 0;
            femaleTotal += dto.getHouseholdMember65().getFemaleTotal() != null ? dto.getHouseholdMember65().getFemaleTotal() : 0;

            sixtySix = (dto.getHouseholdMember65().getMaleTotal() != null ? dto.getHouseholdMember65().getMaleTotal() : 0)
                    + (dto.getHouseholdMember65().getFemaleTotal() != null ? dto.getHouseholdMember65().getFemaleTotal() : 0);
            this.sixty_six = sixtySix.toString();
        }

        this.female_dependants = femaleTotal.toString();
        this.male_dependants = maleTotal.toString();

        this.income_household = dto.getHouseholdIncomeSource() != null ? dto.getHouseholdIncomeSource().name() : null;
        this.average_household = dto.getHouseholdMonthlyAvgIncome() != null ? dto.getHouseholdMonthlyAvgIncome().toString() : null;
        this.household_size = dto.getHouseholdSize() != null ? dto.getHouseholdSize().toString() : null;

        if (dto.getAddress() != null) {
            this.state = dto.getAddress().getStateId() != null ? dto.getAddress().getStateId().toString() : null;
            this.county = dto.getAddress().getCountyId() != null ? dto.getAddress().getCountyId().toString() : null;
            this.boma = dto.getAddress().getBoma() != null ? dto.getAddress().getBoma().toString() : null;
            this.payam = dto.getAddress().getPayam() != null ? dto.getAddress().getPayam().toString() : null;
        }

        if (dto.getLocation() != null) {
            this.latitude = dto.getLocation().getLat() != null ? dto.getLocation().getLat().toString() : null;
            this.longitude = dto.getLocation().getLon() != null ? dto.getLocation().getLon().toString() : null;
        }

        this.legal_status = dto.getRespondentLegalStatus() != null ? dto.getRespondentLegalStatus().name() : null;
        this.selection_criteria = dto.getSelectionCriteria() != null ? dto.getSelectionCriteria().getValue() : null;
        if (dto.getSelectionReason() != null && dto.getSelectionReason().size() > 0) {
            int count = 1;
            for(SelectionReasonEnum selectionReason : dto.getSelectionReason()){
                if (selectionReason != null) {
                    this.selection_reason += selectionReason.getValue();
                }
                if(count < dto.getSelectionReason().size()){
                    this.selection_reason += ", ";
                    count++;
                }
            }
        }
        
        this.household_photo_url = dto.getPhotoUrl();

        Integer alternateNumber = 0;
        if (dto.getAlternatePayee1() != null) {
            alternateNumber += 1;
            
            AlternateDto alt = dto.getAlternatePayee1();
            
            this.alt1Name = alt.getPayeeFirstName() + " " + alt.getPayeeMiddleName() + " " + alt.getPayeeLastName();
            if (alt.getPayeeGender() == GenderEnum.MALE) {
                this.alt1Gender = "M";
            }
            if (alt.getPayeeGender() == GenderEnum.FEMALE) {
                this.alt1Gender = "F";
            }
            if(alt.getPayeeAge() != null){
                this.alt1Age = alt.getPayeeAge().toString();
            }
            this.alt1Mobile = alt.getPayeePhoneNo();
            this.alt1Nid = alt.getNationalId();
            this.alt1_photo_url = alt.getPhotoUrl();
        }
        
        if (dto.getAlternatePayee2() != null) {
            alternateNumber += 1;
            
            AlternateDto alt = dto.getAlternatePayee2();
            
            this.alt2Name = alt.getPayeeFirstName() + " " + alt.getPayeeMiddleName() + " " + alt.getPayeeLastName();
            if (alt.getPayeeGender() == GenderEnum.MALE) {
                this.alt2Gender = "M";
            }
            if (alt.getPayeeGender() == GenderEnum.FEMALE) {
                this.alt2Gender = "F";
            }
            if(alt.getPayeeAge() != null){
                this.alt2Age = alt.getPayeeAge().toString();
            }
            this.alt2Mobile = alt.getPayeePhoneNo();
            this.alt2Nid = alt.getNationalId();
            this.alt2_photo_url = alt.getPhotoUrl();
        }
        this.alternate_number = alternateNumber.toString();
        
        if(dto.getNominees() != null && dto.getNominees().size() > 0){
            this.nomineeList = dto.getNominees().parallelStream().map(n->{
                return new MisNomineeDto(n);
            }).collect(Collectors.toList());
        }

        this.created_at = Utils.dateToString(dto.getCreated(), "yyyy-MM-dd hh:mm:ss");
        this.updated_at = Utils.dateToString(dto.getUpdated(), "yyyy-MM-dd hh:mm:ss");

        //// static data
        this.partner_code = "1001";
        this.beneficiary_type = "1";
//        this.boma = "1000";
//        this.payam = "1010";
//        this.county = "1007";
//        this.state = "1008";
    }
}
