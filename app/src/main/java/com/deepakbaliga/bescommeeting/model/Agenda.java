package com.deepakbaliga.bescommeeting.model;

/**
 * Created by baliga on 12/05/16.
 */
public class Agenda
{
    private String SubjectAgendaNumber;

    private String SubjectCategoryName;

    private String SubjectDesc;

    private String SubjectNumber;

    private String SubjectPriorityOrder;

    private String ApprovalStatusDesc;

    private String SubscriptionCode;

    private String SubjectCode;

    private String SubjectName;

    private String IsActive;

    private String ApprovalStatus;

    private String DepartmentCode;

    private String SubjectCategoryCode;

    private String DepartmentName;

    private String IsSubjectAgenda;

    public String getSubjectAgendaNumber ()
    {
        return SubjectAgendaNumber;
    }

    public void setSubjectAgendaNumber (String SubjectAgendaNumber)
    {
        this.SubjectAgendaNumber = SubjectAgendaNumber;
    }

    public String getSubjectCategoryName ()
    {
        return SubjectCategoryName;
    }

    public void setSubjectCategoryName (String SubjectCategoryName)
    {
        this.SubjectCategoryName = SubjectCategoryName;
    }

    public String getSubjectDesc ()
    {
        return SubjectDesc;
    }

    public void setSubjectDesc (String SubjectDesc)
    {
        this.SubjectDesc = SubjectDesc;
    }

    public String getSubjectNumber ()
    {
        return SubjectNumber;
    }

    public void setSubjectNumber (String SubjectNumber)
    {
        this.SubjectNumber = SubjectNumber;
    }

    public String getSubjectPriorityOrder ()
    {
        return SubjectPriorityOrder;
    }

    public void setSubjectPriorityOrder (String SubjectPriorityOrder)
    {
        this.SubjectPriorityOrder = SubjectPriorityOrder;
    }

    public String getApprovalStatusDesc ()
    {
        return ApprovalStatusDesc;
    }

    public void setApprovalStatusDesc (String ApprovalStatusDesc)
    {
        this.ApprovalStatusDesc = ApprovalStatusDesc;
    }

    public String getSubscriptionCode ()
    {
        return SubscriptionCode;
    }

    public void setSubscriptionCode (String SubscriptionCode)
    {
        this.SubscriptionCode = SubscriptionCode;
    }

    public String getSubjectCode ()
    {
        return SubjectCode;
    }

    public void setSubjectCode (String SubjectCode)
    {
        this.SubjectCode = SubjectCode;
    }

    public String getSubjectName ()
    {
        return SubjectName;
    }

    public void setSubjectName (String SubjectName)
    {
        this.SubjectName = SubjectName;
    }

    public String getIsActive ()
    {
        return IsActive;
    }

    public void setIsActive (String IsActive)
    {
        this.IsActive = IsActive;
    }

    public String getApprovalStatus ()
    {
        return ApprovalStatus;
    }

    public void setApprovalStatus (String ApprovalStatus)
    {
        this.ApprovalStatus = ApprovalStatus;
    }

    public String getDepartmentCode ()
    {
        return DepartmentCode;
    }

    public void setDepartmentCode (String DepartmentCode)
    {
        this.DepartmentCode = DepartmentCode;
    }

    public String getSubjectCategoryCode ()
    {
        return SubjectCategoryCode;
    }

    public void setSubjectCategoryCode (String SubjectCategoryCode)
    {
        this.SubjectCategoryCode = SubjectCategoryCode;
    }

    public String getDepartmentName ()
    {
        return DepartmentName;
    }

    public void setDepartmentName (String DepartmentName)
    {
        this.DepartmentName = DepartmentName;
    }

    public String getIsSubjectAgenda ()
    {
        return IsSubjectAgenda;
    }

    public void setIsSubjectAgenda (String IsSubjectAgenda)
    {
        this.IsSubjectAgenda = IsSubjectAgenda;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [SubjectAgendaNumber = "+SubjectAgendaNumber+", SubjectCategoryName = "+SubjectCategoryName+", SubjectDesc = "+SubjectDesc+", SubjectNumber = "+SubjectNumber+", SubjectPriorityOrder = "+SubjectPriorityOrder+", ApprovalStatusDesc = "+ApprovalStatusDesc+", SubscriptionCode = "+SubscriptionCode+", SubjectCode = "+SubjectCode+", SubjectName = "+SubjectName+", IsActive = "+IsActive+", ApprovalStatus = "+ApprovalStatus+", DepartmentCode = "+DepartmentCode+", SubjectCategoryCode = "+SubjectCategoryCode+", DepartmentName = "+DepartmentName+", IsSubjectAgenda = "+IsSubjectAgenda+"]";
    }
}

