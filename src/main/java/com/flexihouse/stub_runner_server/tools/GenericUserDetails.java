package com.flexihouse.stub_runner_server.tools;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bson.types.ObjectId;
import wiremock.com.google.common.base.Strings;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

@Data
@EqualsAndHashCode(of = "credentialsId")
public class GenericUserDetails {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private ObjectId credentialsId;
    @Email(groups = {New.class, Exists.class})
    @Size(min = 1, groups = {New.class, Exists.class})
    @NotNull(groups = {New.class})
    private String username;
    @NotEmpty(groups = {New.class})
    private String password;
    @NotEmpty(groups = {New.class})
    private String firstName;
    @NotEmpty(groups = {New.class})
    private String lastName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(hidden = true)
    private Date createdAt;
    @Pattern(regexp = "^[0-9]{10}$", groups = {New.class, Exists.class})
    private String phoneNumber;
    private boolean enabled = true;
    @ApiModelProperty(hidden = true)
    private UserType userType;
    @NotNull(groups = {New.class})
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Locale locale;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private String avatar;
    private Set<FlatPermission> grantedPermissions;

    @JsonProperty("password")
    public String getNullPassword() {
        return null;
    }

    @JsonIgnore
    public String getFormattedName() {
        if (!Strings.isNullOrEmpty(firstName)) {
            if (!Strings.isNullOrEmpty(lastName)) {
                return firstName + " " + lastName;
            }
        }
        return username;
    }

    public interface New {

    }

    public interface Exists {

    }
}
