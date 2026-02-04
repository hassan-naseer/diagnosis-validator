package com.codevalidator.code_validator.service;

import com.codevalidator.code_validator.model.SubcategoryDefinition;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubcategoryService {
    
    private List<SubcategoryDefinition> subcategories = new ArrayList<>();

    @PostConstruct
    public void initializeSubcategories() {
        System.out.println("Loading subcategories...");
        
        // Load all chapters
        loadChapterA_InfectiousAndParasiticDiseases();
        loadChapterC_Neoplasms();
        loadChapterD_BloodDiseases();
        loadChapterE_EndocrineNutritionalMetabolic();
        loadChapterF_MentalBehavioral();
        loadChapterG_NervousSystem();
        loadChapterH_Eye_Ear();
        loadChapterI_Circulatory();
        loadChapterJ_Respiratory();
        loadChapterK_Digestive();
        loadChapterL_Skin();
        loadChapterM_Musculoskeletal();
        loadChapterN_Genitourinary();
        loadChapterO_Pregnancy();
        loadChapterP_Perinatal();
        loadChapterQ_Congenital();
        loadChapterR_SymptomsAndSigns();
        loadChapterS_T_Injury();
        loadChapterV_Y_ExternalCauses();
        loadChapterZ_HealthStatus();
        
        System.out.println("Loaded " + subcategories.size() + " subcategory definitions");
    }

        // CHAPTER A: Infectious and Parasitic Diseases (A00-B99)
    private void loadChapterA_InfectiousAndParasiticDiseases() {
        // Intestinal infectious diseases (A00-A09)
        subcategories.add(new SubcategoryDefinition("A00", "Intestinal infectious diseases", "Cholera", null, null));
        subcategories.add(new SubcategoryDefinition("A01", "Intestinal infectious diseases", "Typhoid and paratyphoid fevers", null, null));
        subcategories.add(new SubcategoryDefinition("A02", "Intestinal infectious diseases", "Other salmonella infections", null, null));
        subcategories.add(new SubcategoryDefinition("A03", "Intestinal infectious diseases", "Shigellosis", null, null));
        subcategories.add(new SubcategoryDefinition("A04", "Intestinal infectious diseases", "Other bacterial intestinal infections", null, null));
        subcategories.add(new SubcategoryDefinition("A05", "Intestinal infectious diseases", "Other bacterial foodborne intoxications", null, null));
        subcategories.add(new SubcategoryDefinition("A06", "Intestinal infectious diseases", "Amebiasis", null, null));
        subcategories.add(new SubcategoryDefinition("A07", "Intestinal infectious diseases", "Other protozoal intestinal diseases", null, null));
        subcategories.add(new SubcategoryDefinition("A08", "Intestinal infectious diseases", "Viral and other intestinal infections", null, null));
        subcategories.add(new SubcategoryDefinition("A09", "Intestinal infectious diseases", "Infectious gastroenteritis and colitis", null, null));
        
        // Tuberculosis (A15-A19)
        subcategories.add(new SubcategoryDefinition("A15", "Tuberculosis", "Respiratory tuberculosis", null, null));
        subcategories.add(new SubcategoryDefinition("A17", "Tuberculosis", "Tuberculosis of nervous system", null, null));
        subcategories.add(new SubcategoryDefinition("A18", "Tuberculosis", "Tuberculosis of other organs", null, null));
        subcategories.add(new SubcategoryDefinition("A19", "Tuberculosis", "Miliary tuberculosis", null, null));
        
        // Zoonotic bacterial diseases (A20-A28)
        subcategories.add(new SubcategoryDefinition("A20", "Certain zoonotic bacterial diseases", "Plague", null, null));
        subcategories.add(new SubcategoryDefinition("A21", "Certain zoonotic bacterial diseases", "Tularemia", null, null));
        subcategories.add(new SubcategoryDefinition("A22", "Certain zoonotic bacterial diseases", "Anthrax", null, null));
        subcategories.add(new SubcategoryDefinition("A23", "Certain zoonotic bacterial diseases", "Brucellosis", null, null));
        subcategories.add(new SubcategoryDefinition("A24", "Certain zoonotic bacterial diseases", "Glanders and melioidosis", null, null));
        subcategories.add(new SubcategoryDefinition("A25", "Certain zoonotic bacterial diseases", "Rat-bite fevers", null, null));
        subcategories.add(new SubcategoryDefinition("A26", "Certain zoonotic bacterial diseases", "Erysipeloid", null, null));
        subcategories.add(new SubcategoryDefinition("A27", "Certain zoonotic bacterial diseases", "Leptospirosis", null, null));
        subcategories.add(new SubcategoryDefinition("A28", "Certain zoonotic bacterial diseases", "Other zoonotic bacterial diseases", null, null));
        
        // Viral infections (B00-B34)
        subcategories.add(new SubcategoryDefinition("B00", "Viral infections characterized by skin and mucous membrane lesions", "Herpesviral infections", null, null));
        subcategories.add(new SubcategoryDefinition("B01", "Viral infections characterized by skin and mucous membrane lesions", "Varicella (chickenpox)", null, null));
        subcategories.add(new SubcategoryDefinition("B02", "Viral infections characterized by skin and mucous membrane lesions", "Zoster (shingles)", null, null));
        subcategories.add(new SubcategoryDefinition("B15", "Viral hepatitis", "Acute hepatitis A", null, null));
        subcategories.add(new SubcategoryDefinition("B16", "Viral hepatitis", "Acute hepatitis B", null, null));
        subcategories.add(new SubcategoryDefinition("B17", "Viral hepatitis", "Other acute viral hepatitis", null, null));
        subcategories.add(new SubcategoryDefinition("B18", "Viral hepatitis", "Chronic viral hepatitis", null, null));
        subcategories.add(new SubcategoryDefinition("B19", "Viral hepatitis", "Unspecified viral hepatitis", null, null));
        subcategories.add(new SubcategoryDefinition("B20", "Human immunodeficiency virus [HIV] disease", "HIV disease", null, null));
    }

    // CHAPTER C: Neoplasms (C00-D49)
    private void loadChapterC_Neoplasms() {
        // Malignant neoplasms by site
        subcategories.add(new SubcategoryDefinition("C00", "Malignant neoplasms of lip, oral cavity and pharynx", "Malignant neoplasm of lip", null, null));
        subcategories.add(new SubcategoryDefinition("C01", "Malignant neoplasms of lip, oral cavity and pharynx", "Malignant neoplasm of base of tongue", null, null));
        subcategories.add(new SubcategoryDefinition("C15", "Malignant neoplasms of digestive organs", "Malignant neoplasm of esophagus", null, null));
        subcategories.add(new SubcategoryDefinition("C16", "Malignant neoplasms of digestive organs", "Malignant neoplasm of stomach", null, null));
        subcategories.add(new SubcategoryDefinition("C18", "Malignant neoplasms of digestive organs", "Malignant neoplasm of colon", null, null));
        subcategories.add(new SubcategoryDefinition("C19", "Malignant neoplasms of digestive organs", "Malignant neoplasm of rectosigmoid junction", null, null));
        subcategories.add(new SubcategoryDefinition("C20", "Malignant neoplasms of digestive organs", "Malignant neoplasm of rectum", null, null));
        subcategories.add(new SubcategoryDefinition("C22", "Malignant neoplasms of digestive organs", "Malignant neoplasm of liver and intrahepatic bile ducts", null, null));
        subcategories.add(new SubcategoryDefinition("C25", "Malignant neoplasms of digestive organs", "Malignant neoplasm of pancreas", null, null));
        subcategories.add(new SubcategoryDefinition("C34", "Malignant neoplasms of respiratory and intrathoracic organs", "Malignant neoplasm of bronchus and lung", null, null));
        subcategories.add(new SubcategoryDefinition("C43", "Melanoma and other malignant neoplasms of skin", "Malignant melanoma of skin", null, null));
        subcategories.add(new SubcategoryDefinition("C44", "Melanoma and other malignant neoplasms of skin", "Other malignant neoplasms of skin", null, null));
        subcategories.add(new SubcategoryDefinition("C50", "Malignant neoplasms of breast", "Malignant neoplasm of breast", null, null));
        subcategories.add(new SubcategoryDefinition("C61", "Malignant neoplasms of male genital organs", "Malignant neoplasm of prostate", null, null));
        subcategories.add(new SubcategoryDefinition("C64", "Malignant neoplasms of urinary tract", "Malignant neoplasm of kidney", null, null));
        subcategories.add(new SubcategoryDefinition("C67", "Malignant neoplasms of urinary tract", "Malignant neoplasm of bladder", null, null));
        subcategories.add(new SubcategoryDefinition("C71", "Malignant neoplasms of eye, brain and other parts of central nervous system", "Malignant neoplasm of brain", null, null));
        subcategories.add(new SubcategoryDefinition("C73", "Malignant neoplasms of thyroid and other endocrine glands", "Malignant neoplasm of thyroid gland", null, null));
        subcategories.add(new SubcategoryDefinition("C81", "Malignant neoplasms of lymphoid, hematopoietic and related tissue", "Hodgkin lymphoma", null, null));
        subcategories.add(new SubcategoryDefinition("C82", "Malignant neoplasms of lymphoid, hematopoietic and related tissue", "Follicular lymphoma", null, null));
        subcategories.add(new SubcategoryDefinition("C83", "Malignant neoplasms of lymphoid, hematopoietic and related tissue", "Non-follicular lymphoma", null, null));
        subcategories.add(new SubcategoryDefinition("C90", "Malignant neoplasms of lymphoid, hematopoietic and related tissue", "Multiple myeloma and malignant plasma cell neoplasms", null, null));
        subcategories.add(new SubcategoryDefinition("C91", "Malignant neoplasms of lymphoid, hematopoietic and related tissue", "Lymphoid leukemia", null, null));
        subcategories.add(new SubcategoryDefinition("C92", "Malignant neoplasms of lymphoid, hematopoietic and related tissue", "Myeloid leukemia", null, null));
    }

    // CHAPTER D: Diseases of Blood and Blood-forming Organs (D50-D89)
    private void loadChapterD_BloodDiseases() {
        subcategories.add(new SubcategoryDefinition("D50", "Nutritional anemias", "Iron deficiency anemia", null, null));
        subcategories.add(new SubcategoryDefinition("D51", "Nutritional anemias", "Vitamin B12 deficiency anemia", null, null));
        subcategories.add(new SubcategoryDefinition("D52", "Nutritional anemias", "Folate deficiency anemia", null, null));
        subcategories.add(new SubcategoryDefinition("D53", "Nutritional anemias", "Other nutritional anemias", null, null));
        subcategories.add(new SubcategoryDefinition("D55", "Hemolytic anemias", "Anemia due to enzyme disorders", null, null));
        subcategories.add(new SubcategoryDefinition("D56", "Hemolytic anemias", "Thalassemia", null, null));
        subcategories.add(new SubcategoryDefinition("D57", "Hemolytic anemias", "Sickle-cell disorders", null, null));
        subcategories.add(new SubcategoryDefinition("D58", "Hemolytic anemias", "Other hereditary hemolytic anemias", null, null));
        subcategories.add(new SubcategoryDefinition("D59", "Hemolytic anemias", "Acquired hemolytic anemia", null, null));
        subcategories.add(new SubcategoryDefinition("D60", "Aplastic and other anemias", "Acquired pure red cell aplasia", null, null));
        subcategories.add(new SubcategoryDefinition("D61", "Aplastic and other anemias", "Other aplastic anemias and bone marrow failure syndromes", null, null));
        subcategories.add(new SubcategoryDefinition("D65", "Coagulation defects, purpura and other hemorrhagic conditions", "Disseminated intravascular coagulation", null, null));
        subcategories.add(new SubcategoryDefinition("D66", "Coagulation defects, purpura and other hemorrhagic conditions", "Hereditary factor VIII deficiency", null, null));
        subcategories.add(new SubcategoryDefinition("D68", "Coagulation defects, purpura and other hemorrhagic conditions", "Other coagulation defects", null, null));
        subcategories.add(new SubcategoryDefinition("D69", "Coagulation defects, purpura and other hemorrhagic conditions", "Purpura and other hemorrhagic conditions", null, null));
    }

    // CHAPTER E: Endocrine, Nutritional and Metabolic Diseases (E00-E89)
    private void loadChapterE_EndocrineNutritionalMetabolic() {
        // Thyroid disorders
        subcategories.add(new SubcategoryDefinition("E00", "Disorders of thyroid gland", "Congenital iodine-deficiency syndrome", null, null));
        subcategories.add(new SubcategoryDefinition("E01", "Disorders of thyroid gland", "Iodine-deficiency related thyroid disorders", null, null));
        subcategories.add(new SubcategoryDefinition("E02", "Disorders of thyroid gland", "Subclinical iodine-deficiency hypothyroidism", null, null));
        subcategories.add(new SubcategoryDefinition("E03", "Disorders of thyroid gland", "Other hypothyroidism", null, null));
        subcategories.add(new SubcategoryDefinition("E04", "Disorders of thyroid gland", "Other nontoxic goiter", null, null));
        subcategories.add(new SubcategoryDefinition("E05", "Disorders of thyroid gland", "Thyrotoxicosis (hyperthyroidism)", null, null));
        subcategories.add(new SubcategoryDefinition("E06", "Disorders of thyroid gland", "Thyroiditis", null, null));
        subcategories.add(new SubcategoryDefinition("E07", "Disorders of thyroid gland", "Other disorders of thyroid", null, null));
        
        // Diabetes mellitus (E08-E13) - Already comprehensive, keeping existing
        subcategories.add(new SubcategoryDefinition("E08", "Diabetes mellitus", "Diabetes mellitus due to underlying condition", null, null));
        subcategories.add(new SubcategoryDefinition("E09", "Diabetes mellitus", "Drug or chemical induced diabetes mellitus", null, null));
        subcategories.add(new SubcategoryDefinition("E10", "Diabetes mellitus", "Type 1 diabetes mellitus", null, null));
        subcategories.add(new SubcategoryDefinition("E11", "Diabetes mellitus", "Type 2 diabetes mellitus", null, null));
        subcategories.add(new SubcategoryDefinition("E13", "Diabetes mellitus", "Other specified diabetes mellitus", null, null));
        
        // Type 2 diabetes complications (Level 2)
        subcategories.add(new SubcategoryDefinition("E11", "Diabetes mellitus", "Type 2 diabetes mellitus", "E11.0", "Type 2 diabetes with hyperosmolarity"));
        subcategories.add(new SubcategoryDefinition("E11", "Diabetes mellitus", "Type 2 diabetes mellitus", "E11.1", "Type 2 diabetes with ketoacidosis"));
        subcategories.add(new SubcategoryDefinition("E11", "Diabetes mellitus", "Type 2 diabetes mellitus", "E11.2", "Type 2 diabetes with kidney complications"));
        subcategories.add(new SubcategoryDefinition("E11", "Diabetes mellitus", "Type 2 diabetes mellitus", "E11.3", "Type 2 diabetes with ophthalmic complications"));
        subcategories.add(new SubcategoryDefinition("E11", "Diabetes mellitus", "Type 2 diabetes mellitus", "E11.4", "Type 2 diabetes with neurological complications"));
        subcategories.add(new SubcategoryDefinition("E11", "Diabetes mellitus", "Type 2 diabetes mellitus", "E11.5", "Type 2 diabetes with circulatory complications"));
        subcategories.add(new SubcategoryDefinition("E11", "Diabetes mellitus", "Type 2 diabetes mellitus", "E11.6", "Type 2 diabetes with other specified complications"));
        
        // Type 1 diabetes complications (Level 2)
        subcategories.add(new SubcategoryDefinition("E10", "Diabetes mellitus", "Type 1 diabetes mellitus", "E10.2", "Type 1 diabetes with kidney complications"));
        subcategories.add(new SubcategoryDefinition("E10", "Diabetes mellitus", "Type 1 diabetes mellitus", "E10.3", "Type 1 diabetes with ophthalmic complications"));
        subcategories.add(new SubcategoryDefinition("E10", "Diabetes mellitus", "Type 1 diabetes mellitus", "E10.4", "Type 1 diabetes with neurological complications"));
        subcategories.add(new SubcategoryDefinition("E10", "Diabetes mellitus", "Type 1 diabetes mellitus", "E10.5", "Type 1 diabetes with circulatory complications"));
        
        // Other endocrine
        subcategories.add(new SubcategoryDefinition("E20", "Disorders of other endocrine glands", "Hypoparathyroidism", null, null));
        subcategories.add(new SubcategoryDefinition("E21", "Disorders of other endocrine glands", "Hyperparathyroidism and other disorders of parathyroid gland", null, null));
        subcategories.add(new SubcategoryDefinition("E22", "Disorders of other endocrine glands", "Hyperfunction of pituitary gland", null, null));
        subcategories.add(new SubcategoryDefinition("E23", "Disorders of other endocrine glands", "Hypofunction and other disorders of pituitary gland", null, null));
        subcategories.add(new SubcategoryDefinition("E24", "Disorders of other endocrine glands", "Cushing syndrome", null, null));
        subcategories.add(new SubcategoryDefinition("E25", "Disorders of other endocrine glands", "Adrenogenital disorders", null, null));
        subcategories.add(new SubcategoryDefinition("E26", "Disorders of other endocrine glands", "Hyperaldosteronism", null, null));
        subcategories.add(new SubcategoryDefinition("E27", "Disorders of other endocrine glands", "Other disorders of adrenal gland", null, null));
        subcategories.add(new SubcategoryDefinition("E28", "Disorders of other endocrine glands", "Ovarian dysfunction", null, null));
        
        // Malnutrition
        subcategories.add(new SubcategoryDefinition("E40", "Malnutrition", "Kwashiorkor", null, null));
        subcategories.add(new SubcategoryDefinition("E41", "Malnutrition", "Nutritional marasmus", null, null));
        subcategories.add(new SubcategoryDefinition("E42", "Malnutrition", "Marasmic kwashiorkor", null, null));
        subcategories.add(new SubcategoryDefinition("E43", "Malnutrition", "Unspecified severe protein-calorie malnutrition", null, null));
        subcategories.add(new SubcategoryDefinition("E44", "Malnutrition", "Protein-calorie malnutrition of moderate and mild degree", null, null));
        subcategories.add(new SubcategoryDefinition("E45", "Malnutrition", "Retarded development following protein-calorie malnutrition", null, null));
        subcategories.add(new SubcategoryDefinition("E46", "Malnutrition", "Unspecified protein-calorie malnutrition", null, null));
        
        // Obesity
        subcategories.add(new SubcategoryDefinition("E65", "Overweight, obesity and other hyperalimentation", "Localized adiposity", null, null));
        subcategories.add(new SubcategoryDefinition("E66", "Overweight, obesity and other hyperalimentation", "Overweight and obesity", null, null));
        subcategories.add(new SubcategoryDefinition("E67", "Overweight, obesity and other hyperalimentation", "Other hyperalimentation", null, null));
        subcategories.add(new SubcategoryDefinition("E68", "Overweight, obesity and other hyperalimentation", "Sequelae of hyperalimentation", null, null));
        
        // Metabolic disorders
        subcategories.add(new SubcategoryDefinition("E70", "Metabolic disorders", "Disorders of aromatic amino-acid metabolism", null, null));
        subcategories.add(new SubcategoryDefinition("E71", "Metabolic disorders", "Disorders of branched-chain amino-acid metabolism", null, null));
        subcategories.add(new SubcategoryDefinition("E72", "Metabolic disorders", "Other disorders of amino-acid metabolism", null, null));
        subcategories.add(new SubcategoryDefinition("E74", "Metabolic disorders", "Other disorders of carbohydrate metabolism", null, null));
        subcategories.add(new SubcategoryDefinition("E75", "Metabolic disorders", "Disorders of sphingolipid metabolism", null, null));
        subcategories.add(new SubcategoryDefinition("E76", "Metabolic disorders", "Disorders of glycosaminoglycan metabolism", null, null));
        subcategories.add(new SubcategoryDefinition("E77", "Metabolic disorders", "Disorders of glycoprotein metabolism", null, null));
        subcategories.add(new SubcategoryDefinition("E78", "Metabolic disorders", "Disorders of lipoprotein metabolism and other lipidemias", null, null));
        subcategories.add(new SubcategoryDefinition("E79", "Metabolic disorders", "Disorders of purine and pyrimidine metabolism", null, null));
        subcategories.add(new SubcategoryDefinition("E80", "Metabolic disorders", "Disorders of porphyrin and bilirubin metabolism", null, null));
        subcategories.add(new SubcategoryDefinition("E83", "Metabolic disorders", "Disorders of mineral metabolism", null, null));
        subcategories.add(new SubcategoryDefinition("E84", "Metabolic disorders", "Cystic fibrosis", null, null));
        subcategories.add(new SubcategoryDefinition("E85", "Metabolic disorders", "Amyloidosis", null, null));
        subcategories.add(new SubcategoryDefinition("E86", "Metabolic disorders", "Volume depletion", null, null));
        subcategories.add(new SubcategoryDefinition("E87", "Metabolic disorders", "Other disorders of fluid, electrolyte and acid-base balance", null, null));
        subcategories.add(new SubcategoryDefinition("E88", "Metabolic disorders", "Other and unspecified metabolic disorders", null, null));
    }

    // CHAPTER F: Mental and Behavioral Disorders (F01-F99)
    private void loadChapterF_MentalBehavioral() {
        subcategories.add(new SubcategoryDefinition("F01", "Mental disorders due to known physiological conditions", "Vascular dementia", null, null));
        subcategories.add(new SubcategoryDefinition("F02", "Mental disorders due to known physiological conditions", "Dementia in other diseases classified elsewhere", null, null));
        subcategories.add(new SubcategoryDefinition("F03", "Mental disorders due to known physiological conditions", "Unspecified dementia", null, null));
        subcategories.add(new SubcategoryDefinition("F04", "Mental disorders due to known physiological conditions", "Amnestic disorder due to known physiological condition", null, null));
        subcategories.add(new SubcategoryDefinition("F05", "Mental disorders due to known physiological conditions", "Delirium due to known physiological condition", null, null));
        subcategories.add(new SubcategoryDefinition("F10", "Mental and behavioral disorders due to psychoactive substance use", "Alcohol related disorders", null, null));
        subcategories.add(new SubcategoryDefinition("F11", "Mental and behavioral disorders due to psychoactive substance use", "Opioid related disorders", null, null));
        subcategories.add(new SubcategoryDefinition("F12", "Mental and behavioral disorders due to psychoactive substance use", "Cannabis related disorders", null, null));
        subcategories.add(new SubcategoryDefinition("F13", "Mental and behavioral disorders due to psychoactive substance use", "Sedative, hypnotic, or anxiolytic related disorders", null, null));
        subcategories.add(new SubcategoryDefinition("F14", "Mental and behavioral disorders due to psychoactive substance use", "Cocaine related disorders", null, null));
        subcategories.add(new SubcategoryDefinition("F15", "Mental and behavioral disorders due to psychoactive substance use", "Other stimulant related disorders", null, null));
        subcategories.add(new SubcategoryDefinition("F16", "Mental and behavioral disorders due to psychoactive substance use", "Hallucinogen related disorders", null, null));
        subcategories.add(new SubcategoryDefinition("F20", "Schizophrenia, schizotypal, delusional, and other non-mood psychotic disorders", "Schizophrenia", null, null));
        subcategories.add(new SubcategoryDefinition("F21", "Schizophrenia, schizotypal, delusional, and other non-mood psychotic disorders", "Schizotypal disorder", null, null));
        subcategories.add(new SubcategoryDefinition("F22", "Schizophrenia, schizotypal, delusional, and other non-mood psychotic disorders", "Delusional disorders", null, null));
        subcategories.add(new SubcategoryDefinition("F23", "Schizophrenia, schizotypal, delusional, and other non-mood psychotic disorders", "Brief psychotic disorder", null, null));
        subcategories.add(new SubcategoryDefinition("F25", "Schizophrenia, schizotypal, delusional, and other non-mood psychotic disorders", "Schizoaffective disorders", null, null));
        subcategories.add(new SubcategoryDefinition("F28", "Schizophrenia, schizotypal, delusional, and other non-mood psychotic disorders", "Other psychotic disorder not due to a substance", null, null));
        subcategories.add(new SubcategoryDefinition("F29", "Schizophrenia, schizotypal, delusional, and other non-mood psychotic disorders", "Unspecified psychosis not due to a substance", null, null));
        subcategories.add(new SubcategoryDefinition("F30", "Mood [affective] disorders", "Manic episode", null, null));
        subcategories.add(new SubcategoryDefinition("F31", "Mood [affective] disorders", "Bipolar disorder", null, null));
        subcategories.add(new SubcategoryDefinition("F32", "Mood [affective] disorders", "Major depressive disorder, single episode", null, null));
        subcategories.add(new SubcategoryDefinition("F33", "Mood [affective] disorders", "Major depressive disorder, recurrent", null, null));
        subcategories.add(new SubcategoryDefinition("F34", "Mood [affective] disorders", "Persistent mood [affective] disorders", null, null));
        subcategories.add(new SubcategoryDefinition("F40", "Anxiety, dissociative, stress-related, somatoform and other nonpsychotic mental disorders", "Phobic anxiety disorders", null, null));
        subcategories.add(new SubcategoryDefinition("F41", "Anxiety, dissociative, stress-related, somatoform and other nonpsychotic mental disorders", "Other anxiety disorders", null, null));
        subcategories.add(new SubcategoryDefinition("F42", "Anxiety, dissociative, stress-related, somatoform and other nonpsychotic mental disorders", "Obsessive-compulsive disorder", null, null));
        subcategories.add(new SubcategoryDefinition("F43", "Anxiety, dissociative, stress-related, somatoform and other nonpsychotic mental disorders", "Reaction to severe stress, and adjustment disorders", null, null));
        subcategories.add(new SubcategoryDefinition("F44", "Anxiety, dissociative, stress-related, somatoform and other nonpsychotic mental disorders", "Dissociative and conversion disorders", null, null));
        subcategories.add(new SubcategoryDefinition("F45", "Anxiety, dissociative, stress-related, somatoform and other nonpsychotic mental disorders", "Somatoform disorders", null, null));
        subcategories.add(new SubcategoryDefinition("F50", "Behavioral syndromes associated with physiological disturbances and physical factors", "Eating disorders", null, null));
        subcategories.add(new SubcategoryDefinition("F51", "Behavioral syndromes associated with physiological disturbances and physical factors", "Sleep disorders not due to a substance", null, null));
        subcategories.add(new SubcategoryDefinition("F52", "Behavioral syndromes associated with physiological disturbances and physical factors", "Sexual dysfunction not due to a substance", null, null));
        subcategories.add(new SubcategoryDefinition("F60", "Disorders of adult personality and behavior", "Specific personality disorders", null, null));
        subcategories.add(new SubcategoryDefinition("F63", "Disorders of adult personality and behavior", "Impulse disorders", null, null));
        subcategories.add(new SubcategoryDefinition("F64", "Disorders of adult personality and behavior", "Gender identity disorders", null, null));
        subcategories.add(new SubcategoryDefinition("F80", "Pervasive and specific developmental disorders", "Specific developmental disorders of speech and language", null, null));
        subcategories.add(new SubcategoryDefinition("F81", "Pervasive and specific developmental disorders", "Specific developmental disorders of scholastic skills", null, null));
        subcategories.add(new SubcategoryDefinition("F82", "Pervasive and specific developmental disorders", "Specific developmental disorder of motor function", null, null));
        subcategories.add(new SubcategoryDefinition("F84", "Pervasive and specific developmental disorders", "Pervasive developmental disorders", null, null));
        subcategories.add(new SubcategoryDefinition("F90", "Behavioral and emotional disorders with onset usually occurring in childhood and adolescence", "Attention-deficit hyperactivity disorders", null, null));
        subcategories.add(new SubcategoryDefinition("F91", "Behavioral and emotional disorders with onset usually occurring in childhood and adolescence", "Conduct disorders", null, null));
        subcategories.add(new SubcategoryDefinition("F93", "Behavioral and emotional disorders with onset usually occurring in childhood and adolescence", "Emotional disorders with onset specific to childhood", null, null));
        subcategories.add(new SubcategoryDefinition("F94", "Behavioral and emotional disorders with onset usually occurring in childhood and adolescence", "Disorders of social functioning with onset specific to childhood", null, null));
        subcategories.add(new SubcategoryDefinition("F95", "Behavioral and emotional disorders with onset usually occurring in childhood and adolescence", "Tic disorders", null, null));
    }

    // CHAPTER G: Diseases of the Nervous System (G00-G99)
    private void loadChapterG_NervousSystem() {
        subcategories.add(new SubcategoryDefinition("G00", "Inflammatory diseases of the central nervous system", "Bacterial meningitis", null, null));
        subcategories.add(new SubcategoryDefinition("G03", "Inflammatory diseases of the central nervous system", "Meningitis due to other and unspecified causes", null, null));
        subcategories.add(new SubcategoryDefinition("G04", "Inflammatory diseases of the central nervous system", "Encephalitis, myelitis and encephalomyelitis", null, null));
        subcategories.add(new SubcategoryDefinition("G06", "Inflammatory diseases of the central nervous system", "Intracranial and intraspinal abscess", null, null));
        subcategories.add(new SubcategoryDefinition("G10", "Systemic atrophies primarily affecting the central nervous system", "Huntington disease", null, null));
        subcategories.add(new SubcategoryDefinition("G11", "Systemic atrophies primarily affecting the central nervous system", "Hereditary ataxia", null, null));
        subcategories.add(new SubcategoryDefinition("G12", "Systemic atrophies primarily affecting the central nervous system", "Spinal muscular atrophy", null, null));
        subcategories.add(new SubcategoryDefinition("G13", "Systemic atrophies primarily affecting the central nervous system", "Systemic atrophies affecting CNS in diseases classified elsewhere", null, null));
        subcategories.add(new SubcategoryDefinition("G14", "Systemic atrophies primarily affecting the central nervous system", "Postpolio syndrome", null, null));
        subcategories.add(new SubcategoryDefinition("G20", "Extrapyramidal and movement disorders", "Parkinson disease", null, null));
        subcategories.add(new SubcategoryDefinition("G21", "Extrapyramidal and movement disorders", "Secondary parkinsonism", null, null));
        subcategories.add(new SubcategoryDefinition("G23", "Extrapyramidal and movement disorders", "Other degenerative diseases of basal ganglia", null, null));
        subcategories.add(new SubcategoryDefinition("G24", "Extrapyramidal and movement disorders", "Dystonia", null, null));
        subcategories.add(new SubcategoryDefinition("G25", "Extrapyramidal and movement disorders", "Other extrapyramidal and movement disorders", null, null));
        subcategories.add(new SubcategoryDefinition("G26", "Extrapyramidal and movement disorders", "Extrapyramidal and movement disorders in diseases classified elsewhere", null, null));
        subcategories.add(new SubcategoryDefinition("G30", "Other degenerative diseases of the nervous system", "Alzheimer disease", null, null));
        subcategories.add(new SubcategoryDefinition("G31", "Other degenerative diseases of the nervous system", "Other degenerative diseases of nervous system", null, null));
        subcategories.add(new SubcategoryDefinition("G32", "Other degenerative diseases of the nervous system", "Other degenerative disorders of nervous system in diseases classified elsewhere", null, null));
        subcategories.add(new SubcategoryDefinition("G35", "Demyelinating diseases of the central nervous system", "Multiple sclerosis", null, null));
        subcategories.add(new SubcategoryDefinition("G36", "Demyelinating diseases of the central nervous system", "Other acute disseminated demyelination", null, null));
        subcategories.add(new SubcategoryDefinition("G37", "Demyelinating diseases of the central nervous system", "Other demyelinating diseases of CNS", null, null));
        subcategories.add(new SubcategoryDefinition("G40", "Episodic and paroxysmal disorders", "Epilepsy and recurrent seizures", null, null));
        subcategories.add(new SubcategoryDefinition("G43", "Episodic and paroxysmal disorders", "Migraine", null, null));
        subcategories.add(new SubcategoryDefinition("G44", "Episodic and paroxysmal disorders", "Other headache syndromes", null, null));
        subcategories.add(new SubcategoryDefinition("G45", "Episodic and paroxysmal disorders", "Transient cerebral ischemic attacks and related syndromes", null, null));
        subcategories.add(new SubcategoryDefinition("G47", "Episodic and paroxysmal disorders", "Sleep disorders", null, null));
        subcategories.add(new SubcategoryDefinition("G50", "Nerve, nerve root and plexus disorders", "Disorders of trigeminal nerve", null, null));
        subcategories.add(new SubcategoryDefinition("G51", "Nerve, nerve root and plexus disorders", "Facial nerve disorders", null, null));
        subcategories.add(new SubcategoryDefinition("G54", "Nerve, nerve root and plexus disorders", "Nerve root and plexus disorders", null, null));
        subcategories.add(new SubcategoryDefinition("G56", "Nerve, nerve root and plexus disorders", "Mononeuropathies of upper limb", null, null));
        subcategories.add(new SubcategoryDefinition("G57", "Nerve, nerve root and plexus disorders", "Mononeuropathies of lower limb", null, null));
        subcategories.add(new SubcategoryDefinition("G60", "Polyneuropathies and other disorders of the peripheral nervous system", "Hereditary and idiopathic neuropathy", null, null));
        subcategories.add(new SubcategoryDefinition("G61", "Polyneuropathies and other disorders of the peripheral nervous system", "Inflammatory polyneuropathy", null, null));
        subcategories.add(new SubcategoryDefinition("G62", "Polyneuropathies and other disorders of the peripheral nervous system", "Other and unspecified polyneuropathies", null, null));
        subcategories.add(new SubcategoryDefinition("G63", "Polyneuropathies and other disorders of the peripheral nervous system", "Polyneuropathy in diseases classified elsewhere", null, null));
        subcategories.add(new SubcategoryDefinition("G70", "Diseases of myoneural junction and muscle", "Myasthenia gravis and other myoneural disorders", null, null));
        subcategories.add(new SubcategoryDefinition("G71", "Diseases of myoneural junction and muscle", "Primary disorders of muscles", null, null));
        subcategories.add(new SubcategoryDefinition("G72", "Diseases of myoneural junction and muscle", "Other and unspecified myopathies", null, null));
        subcategories.add(new SubcategoryDefinition("G73", "Diseases of myoneural junction and muscle", "Disorders of myoneural junction and muscle in diseases classified elsewhere", null, null));
        subcategories.add(new SubcategoryDefinition("G80", "Cerebral palsy and other paralytic syndromes", "Cerebral palsy", null, null));
        subcategories.add(new SubcategoryDefinition("G81", "Cerebral palsy and other paralytic syndromes", "Hemiplegia and hemiparesis", null, null));
        subcategories.add(new SubcategoryDefinition("G82", "Cerebral palsy and other paralytic syndromes", "Paraplegia (paraparesis) and quadriplegia (quadriparesis)", null, null));
        subcategories.add(new SubcategoryDefinition("G83", "Cerebral palsy and other paralytic syndromes", "Other paralytic syndromes", null, null));
        subcategories.add(new SubcategoryDefinition("G89", "Other disorders of the nervous system", "Pain, not elsewhere classified", null, null));
        subcategories.add(new SubcategoryDefinition("G90", "Other disorders of the nervous system", "Disorders of autonomic nervous system", null, null));
        subcategories.add(new SubcategoryDefinition("G91", "Other disorders of the nervous system", "Hydrocephalus", null, null));
        subcategories.add(new SubcategoryDefinition("G93", "Other disorders of the nervous system", "Other disorders of brain", null, null));
        subcategories.add(new SubcategoryDefinition("G94", "Other disorders of the nervous system", "Other disorders of brain in diseases classified elsewhere", null, null));
        subcategories.add(new SubcategoryDefinition("G95", "Other disorders of the nervous system", "Other and unspecified diseases of spinal cord", null, null));
        subcategories.add(new SubcategoryDefinition("G96", "Other disorders of the nervous system", "Other disorders of central nervous system", null, null));
        subcategories.add(new SubcategoryDefinition("G97", "Other disorders of the nervous system", "Intraoperative and postprocedural complications of nervous system", null, null));
        subcategories.add(new SubcategoryDefinition("G98", "Other disorders of the nervous system", "Other disorders of nervous system", null, null));
        subcategories.add(new SubcategoryDefinition("G99", "Other disorders of the nervous system", "Other disorders of nervous system in diseases classified elsewhere", null, null));
    }

    // CHAPTER H: Diseases of Eye/Ear (H00-H95)
    private void loadChapterH_Eye_Ear() {
        // Eye disorders
        subcategories.add(new SubcategoryDefinition("H00", "Disorders of eyelid, lacrimal system and orbit", "Hordeolum and chalazion", null, null));
        subcategories.add(new SubcategoryDefinition("H01", "Disorders of eyelid, lacrimal system and orbit", "Other inflammation of eyelid", null, null));
        subcategories.add(new SubcategoryDefinition("H02", "Disorders of eyelid, lacrimal system and orbit", "Other disorders of eyelid", null, null));
        subcategories.add(new SubcategoryDefinition("H04", "Disorders of eyelid, lacrimal system and orbit", "Disorders of lacrimal system", null, null));
        subcategories.add(new SubcategoryDefinition("H05", "Disorders of eyelid, lacrimal system and orbit", "Disorders of orbit", null, null));
        subcategories.add(new SubcategoryDefinition("H10", "Disorders of conjunctiva", "Conjunctivitis", null, null));
        subcategories.add(new SubcategoryDefinition("H11", "Disorders of conjunctiva", "Other disorders of conjunctiva", null, null));
        subcategories.add(new SubcategoryDefinition("H15", "Disorders of sclera, cornea, iris and ciliary body", "Disorders of sclera", null, null));
        subcategories.add(new SubcategoryDefinition("H16", "Disorders of sclera, cornea, iris and ciliary body", "Keratitis", null, null));
        subcategories.add(new SubcategoryDefinition("H17", "Disorders of sclera, cornea, iris and ciliary body", "Corneal scars and opacities", null, null));
        subcategories.add(new SubcategoryDefinition("H18", "Disorders of sclera, cornea, iris and ciliary body", "Other disorders of cornea", null, null));
        subcategories.add(new SubcategoryDefinition("H20", "Disorders of sclera, cornea, iris and ciliary body", "Iridocyclitis", null, null));
        subcategories.add(new SubcategoryDefinition("H21", "Disorders of sclera, cornea, iris and ciliary body", "Other disorders of iris and ciliary body", null, null));
        subcategories.add(new SubcategoryDefinition("H25", "Disorders of lens", "Age-related cataract", null, null));
        subcategories.add(new SubcategoryDefinition("H26", "Disorders of lens", "Other cataract", null, null));
        subcategories.add(new SubcategoryDefinition("H27", "Disorders of lens", "Other disorders of lens", null, null));
        subcategories.add(new SubcategoryDefinition("H28", "Disorders of lens", "Cataract in diseases classified elsewhere", null, null));
        subcategories.add(new SubcategoryDefinition("H30", "Disorders of choroid and retina", "Chorioretinal inflammation", null, null));
        subcategories.add(new SubcategoryDefinition("H31", "Disorders of choroid and retina", "Other disorders of choroid", null, null));
        subcategories.add(new SubcategoryDefinition("H33", "Disorders of choroid and retina", "Retinal detachments and breaks", null, null));
        subcategories.add(new SubcategoryDefinition("H34", "Disorders of choroid and retina", "Retinal vascular occlusions", null, null));
        subcategories.add(new SubcategoryDefinition("H35", "Disorders of choroid and retina", "Other retinal disorders", null, null));
        subcategories.add(new SubcategoryDefinition("H36", "Disorders of choroid and retina", "Retinal disorders in diseases classified elsewhere", null, null));
        subcategories.add(new SubcategoryDefinition("H40", "Glaucoma", "Glaucoma", null, null));
        subcategories.add(new SubcategoryDefinition("H42", "Glaucoma", "Glaucoma in diseases classified elsewhere", null, null));
        subcategories.add(new SubcategoryDefinition("H43", "Disorders of vitreous body and globe", "Disorders of vitreous body", null, null));
        subcategories.add(new SubcategoryDefinition("H44", "Disorders of vitreous body and globe", "Disorders of globe", null, null));
        subcategories.add(new SubcategoryDefinition("H46", "Disorders of optic nerve and visual pathways", "Optic neuritis", null, null));
        subcategories.add(new SubcategoryDefinition("H47", "Disorders of optic nerve and visual pathways", "Other disorders of optic nerve and visual pathways", null, null));
        subcategories.add(new SubcategoryDefinition("H49", "Disorders of ocular muscles, binocular movement, accommodation and refraction", "Paralytic strabismus", null, null));
        subcategories.add(new SubcategoryDefinition("H50", "Disorders of ocular muscles, binocular movement, accommodation and refraction", "Other strabismus", null, null));
        subcategories.add(new SubcategoryDefinition("H52", "Disorders of ocular muscles, binocular movement, accommodation and refraction", "Disorders of refraction and accommodation", null, null));
        subcategories.add(new SubcategoryDefinition("H53", "Visual disturbances and blindness", "Visual disturbances", null, null));
        subcategories.add(new SubcategoryDefinition("H54", "Visual disturbances and blindness", "Blindness and low vision", null, null));
        
        // Ear disorders
        subcategories.add(new SubcategoryDefinition("H60", "Diseases of external ear", "Otitis externa", null, null));
        subcategories.add(new SubcategoryDefinition("H61", "Diseases of external ear", "Other disorders of external ear", null, null));
        subcategories.add(new SubcategoryDefinition("H62", "Diseases of external ear", "Disorders of external ear in diseases classified elsewhere", null, null));
        subcategories.add(new SubcategoryDefinition("H65", "Diseases of middle ear and mastoid", "Nonsuppurative otitis media", null, null));
        subcategories.add(new SubcategoryDefinition("H66", "Diseases of middle ear and mastoid", "Suppurative and unspecified otitis media", null, null));
        subcategories.add(new SubcategoryDefinition("H67", "Diseases of middle ear and mastoid", "Otitis media in diseases classified elsewhere", null, null));
        subcategories.add(new SubcategoryDefinition("H68", "Diseases of middle ear and mastoid", "Eustachian salpingitis and obstruction", null, null));
        subcategories.add(new SubcategoryDefinition("H69", "Diseases of middle ear and mastoid", "Other and unspecified disorders of Eustachian tube", null, null));
        subcategories.add(new SubcategoryDefinition("H70", "Diseases of middle ear and mastoid", "Mastoiditis and related conditions", null, null));
        subcategories.add(new SubcategoryDefinition("H71", "Diseases of middle ear and mastoid", "Cholesteatoma of middle ear", null, null));
        subcategories.add(new SubcategoryDefinition("H72", "Diseases of middle ear and mastoid", "Perforation of tympanic membrane", null, null));
        subcategories.add(new SubcategoryDefinition("H73", "Diseases of middle ear and mastoid", "Other disorders of tympanic membrane", null, null));
        subcategories.add(new SubcategoryDefinition("H74", "Diseases of middle ear and mastoid", "Other disorders of middle ear and mastoid", null, null));
        subcategories.add(new SubcategoryDefinition("H75", "Diseases of middle ear and mastoid", "Other disorders of middle ear and mastoid in diseases classified elsewhere", null, null));
        subcategories.add(new SubcategoryDefinition("H80", "Diseases of inner ear", "Otosclerosis", null, null));
        subcategories.add(new SubcategoryDefinition("H81", "Diseases of inner ear", "Disorders of vestibular function", null, null));
        subcategories.add(new SubcategoryDefinition("H82", "Diseases of inner ear", "Vertiginous syndromes in diseases classified elsewhere", null, null));
        subcategories.add(new SubcategoryDefinition("H83", "Diseases of inner ear", "Other diseases of inner ear", null, null));
        subcategories.add(new SubcategoryDefinition("H90", "Other disorders of ear", "Conductive and sensorineural hearing loss", null, null));
        subcategories.add(new SubcategoryDefinition("H91", "Other disorders of ear", "Other hearing loss", null, null));
        subcategories.add(new SubcategoryDefinition("H92", "Other disorders of ear", "Otalgia and effusion of ear", null, null));
        subcategories.add(new SubcategoryDefinition("H93", "Other disorders of ear", "Other disorders of ear", null, null));
        subcategories.add(new SubcategoryDefinition("H94", "Other disorders of ear", "Other disorders of ear in diseases classified elsewhere", null, null));
    }

    // CHAPTER I: Diseases of the Circulatory System (I00-I99)
    private void loadChapterI_Circulatory() {
        // Hypertensive diseases
        subcategories.add(new SubcategoryDefinition("I10", "Hypertensive diseases", "Essential (primary) hypertension", null, null));
        subcategories.add(new SubcategoryDefinition("I11", "Hypertensive diseases", "Hypertensive heart disease", null, null));
        subcategories.add(new SubcategoryDefinition("I12", "Hypertensive diseases", "Hypertensive chronic kidney disease", null, null));
        subcategories.add(new SubcategoryDefinition("I13", "Hypertensive diseases", "Hypertensive heart and chronic kidney disease", null, null));
        subcategories.add(new SubcategoryDefinition("I15", "Hypertensive diseases", "Secondary hypertension", null, null));
        subcategories.add(new SubcategoryDefinition("I16", "Hypertensive diseases", "Hypertensive crisis", null, null));
        
        // Ischemic heart diseases
        subcategories.add(new SubcategoryDefinition("I20", "Ischemic heart diseases", "Angina pectoris", null, null));
        subcategories.add(new SubcategoryDefinition("I21", "Ischemic heart diseases", "ST elevation (STEMI) and non-ST elevation (NSTEMI) myocardial infarction", null, null));
        subcategories.add(new SubcategoryDefinition("I22", "Ischemic heart diseases", "Subsequent ST elevation (STEMI) and non-ST elevation (NSTEMI) myocardial infarction", null, null));
        subcategories.add(new SubcategoryDefinition("I23", "Ischemic heart diseases", "Certain current complications following myocardial infarction", null, null));
        subcategories.add(new SubcategoryDefinition("I24", "Ischemic heart diseases", "Other acute ischemic heart diseases", null, null));
        subcategories.add(new SubcategoryDefinition("I25", "Ischemic heart diseases", "Chronic ischemic heart disease", null, null));
        
        // Other heart diseases
        subcategories.add(new SubcategoryDefinition("I30", "Other forms of heart disease", "Acute pericarditis", null, null));
        subcategories.add(new SubcategoryDefinition("I31", "Other forms of heart disease", "Other diseases of pericardium", null, null));
        subcategories.add(new SubcategoryDefinition("I32", "Other forms of heart disease", "Pericarditis in diseases classified elsewhere", null, null));
        subcategories.add(new SubcategoryDefinition("I33", "Other forms of heart disease", "Acute and subacute endocarditis", null, null));
        subcategories.add(new SubcategoryDefinition("I34", "Other forms of heart disease", "Nonrheumatic mitral valve disorders", null, null));
        subcategories.add(new SubcategoryDefinition("I35", "Other forms of heart disease", "Nonrheumatic aortic valve disorders", null, null));
        subcategories.add(new SubcategoryDefinition("I36", "Other forms of heart disease", "Nonrheumatic tricuspid valve disorders", null, null));
        subcategories.add(new SubcategoryDefinition("I37", "Other forms of heart disease", "Nonrheumatic pulmonary valve disorders", null, null));
        subcategories.add(new SubcategoryDefinition("I38", "Other forms of heart disease", "Endocarditis, valve unspecified", null, null));
        subcategories.add(new SubcategoryDefinition("I40", "Other forms of heart disease", "Acute myocarditis", null, null));
        subcategories.add(new SubcategoryDefinition("I42", "Other forms of heart disease", "Cardiomyopathy", null, null));
        subcategories.add(new SubcategoryDefinition("I44", "Other forms of heart disease", "Atrioventricular and left bundle-branch block", null, null));
        subcategories.add(new SubcategoryDefinition("I45", "Other forms of heart disease", "Other conduction disorders", null, null));
        subcategories.add(new SubcategoryDefinition("I46", "Other forms of heart disease", "Cardiac arrest", null, null));
        subcategories.add(new SubcategoryDefinition("I47", "Other forms of heart disease", "Paroxysmal tachycardia", null, null));
        subcategories.add(new SubcategoryDefinition("I48", "Other forms of heart disease", "Atrial fibrillation and flutter", null, null));
        subcategories.add(new SubcategoryDefinition("I49", "Other forms of heart disease", "Other cardiac arrhythmias", null, null));
        subcategories.add(new SubcategoryDefinition("I50", "Other forms of heart disease", "Heart failure", null, null));
        subcategories.add(new SubcategoryDefinition("I51", "Other forms of heart disease", "Complications and ill-defined descriptions of heart disease", null, null));
        
        // Cerebrovascular diseases
        subcategories.add(new SubcategoryDefinition("I60", "Cerebrovascular diseases", "Nontraumatic subarachnoid hemorrhage", null, null));
        subcategories.add(new SubcategoryDefinition("I61", "Cerebrovascular diseases", "Nontraumatic intracerebral hemorrhage", null, null));
        subcategories.add(new SubcategoryDefinition("I62", "Cerebrovascular diseases", "Other and unspecified nontraumatic intracranial hemorrhage", null, null));
        subcategories.add(new SubcategoryDefinition("I63", "Cerebrovascular diseases", "Cerebral infarction", null, null));
        subcategories.add(new SubcategoryDefinition("I65", "Cerebrovascular diseases", "Occlusion and stenosis of precerebral arteries", null, null));
        subcategories.add(new SubcategoryDefinition("I66", "Cerebrovascular diseases", "Occlusion and stenosis of cerebral arteries", null, null));
        subcategories.add(new SubcategoryDefinition("I67", "Cerebrovascular diseases", "Other cerebrovascular diseases", null, null));
        subcategories.add(new SubcategoryDefinition("I68", "Cerebrovascular diseases", "Cerebrovascular disorders in diseases classified elsewhere", null, null));
        subcategories.add(new SubcategoryDefinition("I69", "Cerebrovascular diseases", "Sequelae of cerebrovascular disease", null, null));
        
        // Diseases of arteries
        subcategories.add(new SubcategoryDefinition("I70", "Diseases of arteries, arterioles and capillaries", "Atherosclerosis", null, null));
        subcategories.add(new SubcategoryDefinition("I71", "Diseases of arteries, arterioles and capillaries", "Aortic aneurysm and dissection", null, null));
        subcategories.add(new SubcategoryDefinition("I72", "Diseases of arteries, arterioles and capillaries", "Other aneurysm", null, null));
        subcategories.add(new SubcategoryDefinition("I73", "Diseases of arteries, arterioles and capillaries", "Other peripheral vascular diseases", null, null));
        subcategories.add(new SubcategoryDefinition("I74", "Diseases of arteries, arterioles and capillaries", "Arterial embolism and thrombosis", null, null));
        subcategories.add(new SubcategoryDefinition("I77", "Diseases of arteries, arterioles and capillaries", "Other disorders of arteries and arterioles", null, null));
        subcategories.add(new SubcategoryDefinition("I78", "Diseases of arteries, arterioles and capillaries", "Diseases of capillaries", null, null));
        subcategories.add(new SubcategoryDefinition("I79", "Diseases of arteries, arterioles and capillaries", "Disorders of arteries, arterioles and capillaries in diseases classified elsewhere", null, null));
        
        // Diseases of veins
        subcategories.add(new SubcategoryDefinition("I80", "Diseases of veins, lymphatic vessels and lymph nodes", "Phlebitis and thrombophlebitis", null, null));
        subcategories.add(new SubcategoryDefinition("I81", "Diseases of veins, lymphatic vessels and lymph nodes", "Portal vein thrombosis", null, null));
        subcategories.add(new SubcategoryDefinition("I82", "Diseases of veins, lymphatic vessels and lymph nodes", "Other venous embolism and thrombosis", null, null));
        subcategories.add(new SubcategoryDefinition("I83", "Diseases of veins, lymphatic vessels and lymph nodes", "Varicose veins of lower extremities", null, null));
        subcategories.add(new SubcategoryDefinition("I85", "Diseases of veins, lymphatic vessels and lymph nodes", "Esophageal varices", null, null));
        subcategories.add(new SubcategoryDefinition("I86", "Diseases of veins, lymphatic vessels and lymph nodes", "Varicose veins of other sites", null, null));
        subcategories.add(new SubcategoryDefinition("I87", "Diseases of veins, lymphatic vessels and lymph nodes", "Other disorders of veins", null, null));
        subcategories.add(new SubcategoryDefinition("I88", "Diseases of veins, lymphatic vessels and lymph nodes", "Nonspecific lymphadenitis", null, null));
        subcategories.add(new SubcategoryDefinition("I89", "Diseases of veins, lymphatic vessels and lymph nodes", "Other noninfective disorders of lymphatic vessels and lymph nodes", null, null));
    }

    // CHAPTER J: Diseases of the Respiratory System (J00-J99)
    private void loadChapterJ_Respiratory() {
        // Acute upper respiratory infections
        subcategories.add(new SubcategoryDefinition("J00", "Acute upper respiratory infections", "Acute nasopharyngitis (common cold)", null, null));
        subcategories.add(new SubcategoryDefinition("J01", "Acute upper respiratory infections", "Acute sinusitis", null, null));
        subcategories.add(new SubcategoryDefinition("J02", "Acute upper respiratory infections", "Acute pharyngitis", null, null));
        subcategories.add(new SubcategoryDefinition("J03", "Acute upper respiratory infections", "Acute tonsillitis", null, null));
        subcategories.add(new SubcategoryDefinition("J04", "Acute upper respiratory infections", "Acute laryngitis and tracheitis", null, null));
        subcategories.add(new SubcategoryDefinition("J05", "Acute upper respiratory infections", "Acute obstructive laryngitis (croup) and epiglottitis", null, null));
        subcategories.add(new SubcategoryDefinition("J06", "Acute upper respiratory infections", "Acute upper respiratory infections of multiple and unspecified sites", null, null));
        
        // Influenza and pneumonia
        subcategories.add(new SubcategoryDefinition("J09", "Influenza and pneumonia", "Influenza due to certain identified influenza viruses", null, null));
        subcategories.add(new SubcategoryDefinition("J10", "Influenza and pneumonia", "Influenza due to other identified influenza virus", null, null));
        subcategories.add(new SubcategoryDefinition("J11", "Influenza and pneumonia", "Influenza due to unidentified influenza virus", null, null));
        subcategories.add(new SubcategoryDefinition("J12", "Influenza and pneumonia", "Viral pneumonia", null, null));
        subcategories.add(new SubcategoryDefinition("J13", "Influenza and pneumonia", "Pneumonia due to Streptococcus pneumoniae", null, null));
        subcategories.add(new SubcategoryDefinition("J14", "Influenza and pneumonia", "Pneumonia due to Hemophilus influenzae", null, null));
        subcategories.add(new SubcategoryDefinition("J15", "Influenza and pneumonia", "Bacterial pneumonia", null, null));
        subcategories.add(new SubcategoryDefinition("J16", "Influenza and pneumonia", "Pneumonia due to other infectious organisms", null, null));
        subcategories.add(new SubcategoryDefinition("J18", "Influenza and pneumonia", "Pneumonia, unspecified organism", null, null));
        
        // Other acute lower respiratory infections
        subcategories.add(new SubcategoryDefinition("J20", "Other acute lower respiratory infections", "Acute bronchitis", null, null));
        subcategories.add(new SubcategoryDefinition("J21", "Other acute lower respiratory infections", "Acute bronchiolitis", null, null));
        subcategories.add(new SubcategoryDefinition("J22", "Other acute lower respiratory infections", "Unspecified acute lower respiratory infection", null, null));
        
        // Other diseases of upper respiratory tract
        subcategories.add(new SubcategoryDefinition("J30", "Other diseases of upper respiratory tract", "Vasomotor and allergic rhinitis", null, null));
        subcategories.add(new SubcategoryDefinition("J31", "Other diseases of upper respiratory tract", "Chronic rhinitis, nasopharyngitis and pharyngitis", null, null));
        subcategories.add(new SubcategoryDefinition("J32", "Other diseases of upper respiratory tract", "Chronic sinusitis", null, null));
        subcategories.add(new SubcategoryDefinition("J33", "Other diseases of upper respiratory tract", "Nasal polyp", null, null));
        subcategories.add(new SubcategoryDefinition("J34", "Other diseases of upper respiratory tract", "Other and unspecified disorders of nose and nasal sinuses", null, null));
        subcategories.add(new SubcategoryDefinition("J35", "Other diseases of upper respiratory tract", "Chronic diseases of tonsils and adenoids", null, null));
        subcategories.add(new SubcategoryDefinition("J36", "Other diseases of upper respiratory tract", "Peritonsillar abscess", null, null));
        subcategories.add(new SubcategoryDefinition("J37", "Other diseases of upper respiratory tract", "Chronic laryngitis and laryngotracheitis", null, null));
        subcategories.add(new SubcategoryDefinition("J38", "Other diseases of upper respiratory tract", "Diseases of vocal cords and larynx", null, null));
        subcategories.add(new SubcategoryDefinition("J39", "Other diseases of upper respiratory tract", "Other diseases of upper respiratory tract", null, null));
        
        // Chronic lower respiratory diseases
        subcategories.add(new SubcategoryDefinition("J40", "Chronic lower respiratory diseases", "Bronchitis, not specified as acute or chronic", null, null));
        subcategories.add(new SubcategoryDefinition("J41", "Chronic lower respiratory diseases", "Simple and mucopurulent chronic bronchitis", null, null));
        subcategories.add(new SubcategoryDefinition("J42", "Chronic lower respiratory diseases", "Unspecified chronic bronchitis", null, null));
        subcategories.add(new SubcategoryDefinition("J43", "Chronic lower respiratory diseases", "Emphysema", null, null));
        subcategories.add(new SubcategoryDefinition("J44", "Chronic lower respiratory diseases", "Other chronic obstructive pulmonary disease (COPD)", null, null));
        subcategories.add(new SubcategoryDefinition("J45", "Chronic lower respiratory diseases", "Asthma", null, null));
        subcategories.add(new SubcategoryDefinition("J47", "Chronic lower respiratory diseases", "Bronchiectasis", null, null));
        
        // Lung diseases due to external agents
        subcategories.add(new SubcategoryDefinition("J60", "Lung diseases due to external agents", "Coalworker pneumoconiosis", null, null));
        subcategories.add(new SubcategoryDefinition("J61", "Lung diseases due to external agents", "Pneumoconiosis due to asbestos and other mineral fibers", null, null));
        subcategories.add(new SubcategoryDefinition("J62", "Lung diseases due to external agents", "Pneumoconiosis due to dust containing silica", null, null));
        subcategories.add(new SubcategoryDefinition("J63", "Lung diseases due to external agents", "Pneumoconiosis due to other inorganic dusts", null, null));
        subcategories.add(new SubcategoryDefinition("J64", "Lung diseases due to external agents", "Unspecified pneumoconiosis", null, null));
        subcategories.add(new SubcategoryDefinition("J65", "Lung diseases due to external agents", "Pneumoconiosis associated with tuberculosis", null, null));
        subcategories.add(new SubcategoryDefinition("J66", "Lung diseases due to external agents", "Airway disease due to specific organic dust", null, null));
        subcategories.add(new SubcategoryDefinition("J67", "Lung diseases due to external agents", "Hypersensitivity pneumonitis due to organic dust", null, null));
        subcategories.add(new SubcategoryDefinition("J68", "Lung diseases due to external agents", "Respiratory conditions due to inhalation of chemicals, gases, fumes and vapors", null, null));
        subcategories.add(new SubcategoryDefinition("J69", "Lung diseases due to external agents", "Pneumonitis due to solids and liquids", null, null));
        subcategories.add(new SubcategoryDefinition("J70", "Lung diseases due to external agents", "Respiratory conditions due to other external agents", null, null));
        
        // Other respiratory diseases
        subcategories.add(new SubcategoryDefinition("J80", "Other respiratory diseases principally affecting the interstitium", "Acute respiratory distress syndrome", null, null));
        subcategories.add(new SubcategoryDefinition("J81", "Other respiratory diseases principally affecting the interstitium", "Pulmonary edema", null, null));
        subcategories.add(new SubcategoryDefinition("J82", "Other respiratory diseases principally affecting the interstitium", "Pulmonary eosinophilia", null, null));
        subcategories.add(new SubcategoryDefinition("J84", "Other respiratory diseases principally affecting the interstitium", "Other interstitial pulmonary diseases", null, null));
        subcategories.add(new SubcategoryDefinition("J85", "Suppurative and necrotic conditions of the lower respiratory tract", "Abscess of lung and mediastinum", null, null));
        subcategories.add(new SubcategoryDefinition("J86", "Suppurative and necrotic conditions of the lower respiratory tract", "Pyothorax", null, null));
        subcategories.add(new SubcategoryDefinition("J90", "Other diseases of the pleura", "Pleural effusion", null, null));
        subcategories.add(new SubcategoryDefinition("J91", "Other diseases of the pleura", "Pleural effusion in conditions classified elsewhere", null, null));
        subcategories.add(new SubcategoryDefinition("J92", "Other diseases of the pleura", "Pleural plaque", null, null));
        subcategories.add(new SubcategoryDefinition("J93", "Other diseases of the pleura", "Pneumothorax and air leak", null, null));
        subcategories.add(new SubcategoryDefinition("J94", "Other diseases of the pleura", "Other pleural conditions", null, null));
        subcategories.add(new SubcategoryDefinition("J96", "Other diseases of the respiratory system", "Respiratory failure", null, null));
        subcategories.add(new SubcategoryDefinition("J98", "Other diseases of the respiratory system", "Other respiratory disorders", null, null));
        subcategories.add(new SubcategoryDefinition("J99", "Other diseases of the respiratory system", "Respiratory disorders in diseases classified elsewhere", null, null));
    }

    // CHAPTER K: Diseases of the Digestive System (K00-K95)
    private void loadChapterK_Digestive() {
        // Diseases of oral cavity
        subcategories.add(new SubcategoryDefinition("K00", "Diseases of oral cavity and salivary glands", "Disorders of tooth development and eruption", null, null));
        subcategories.add(new SubcategoryDefinition("K01", "Diseases of oral cavity and salivary glands", "Embedded and impacted teeth", null, null));
        subcategories.add(new SubcategoryDefinition("K02", "Diseases of oral cavity and salivary glands", "Dental caries", null, null));
        subcategories.add(new SubcategoryDefinition("K03", "Diseases of oral cavity and salivary glands", "Other diseases of hard tissues of teeth", null, null));
        subcategories.add(new SubcategoryDefinition("K04", "Diseases of oral cavity and salivary glands", "Diseases of pulp and periapical tissues", null, null));
        subcategories.add(new SubcategoryDefinition("K05", "Diseases of oral cavity and salivary glands", "Gingivitis and periodontal diseases", null, null));
        subcategories.add(new SubcategoryDefinition("K06", "Diseases of oral cavity and salivary glands", "Other disorders of gingiva and edentulous alveolar ridge", null, null));
        subcategories.add(new SubcategoryDefinition("K08", "Diseases of oral cavity and salivary glands", "Other disorders of teeth and supporting structures", null, null));
        subcategories.add(new SubcategoryDefinition("K11", "Diseases of oral cavity and salivary glands", "Diseases of salivary glands", null, null));
        subcategories.add(new SubcategoryDefinition("K12", "Diseases of oral cavity and salivary glands", "Stomatitis and related lesions", null, null));
        subcategories.add(new SubcategoryDefinition("K13", "Diseases of oral cavity and salivary glands", "Other diseases of lip and oral mucosa", null, null));
        subcategories.add(new SubcategoryDefinition("K14", "Diseases of oral cavity and salivary glands", "Diseases of tongue", null, null));
        
        // Diseases of esophagus, stomach and duodenum
        subcategories.add(new SubcategoryDefinition("K20", "Diseases of esophagus, stomach and duodenum", "Esophagitis", null, null));
        subcategories.add(new SubcategoryDefinition("K21", "Diseases of esophagus, stomach and duodenum", "Gastro-esophageal reflux disease (GERD)", null, null));
        subcategories.add(new SubcategoryDefinition("K22", "Diseases of esophagus, stomach and duodenum", "Other diseases of esophagus", null, null));
        subcategories.add(new SubcategoryDefinition("K25", "Diseases of esophagus, stomach and duodenum", "Gastric ulcer", null, null));
        subcategories.add(new SubcategoryDefinition("K26", "Diseases of esophagus, stomach and duodenum", "Duodenal ulcer", null, null));
        subcategories.add(new SubcategoryDefinition("K27", "Diseases of esophagus, stomach and duodenum", "Peptic ulcer, site unspecified", null, null));
        subcategories.add(new SubcategoryDefinition("K28", "Diseases of esophagus, stomach and duodenum", "Gastrojejunal ulcer", null, null));
        subcategories.add(new SubcategoryDefinition("K29", "Diseases of esophagus, stomach and duodenum", "Gastritis and duodenitis", null, null));
        subcategories.add(new SubcategoryDefinition("K30", "Diseases of esophagus, stomach and duodenum", "Functional dyspepsia", null, null));
        subcategories.add(new SubcategoryDefinition("K31", "Diseases of esophagus, stomach and duodenum", "Other diseases of stomach and duodenum", null, null));
        
        // Diseases of appendix
        subcategories.add(new SubcategoryDefinition("K35", "Diseases of appendix", "Acute appendicitis", null, null));
        subcategories.add(new SubcategoryDefinition("K36", "Diseases of appendix", "Other appendicitis", null, null));
        subcategories.add(new SubcategoryDefinition("K37", "Diseases of appendix", "Unspecified appendicitis", null, null));
        subcategories.add(new SubcategoryDefinition("K38", "Diseases of appendix", "Other diseases of appendix", null, null));
        
        // Hernia
        subcategories.add(new SubcategoryDefinition("K40", "Hernia", "Inguinal hernia", null, null));
        subcategories.add(new SubcategoryDefinition("K41", "Hernia", "Femoral hernia", null, null));
        subcategories.add(new SubcategoryDefinition("K42", "Hernia", "Umbilical hernia", null, null));
        subcategories.add(new SubcategoryDefinition("K43", "Hernia", "Ventral hernia", null, null));
        subcategories.add(new SubcategoryDefinition("K44", "Hernia", "Diaphragmatic hernia", null, null));
        subcategories.add(new SubcategoryDefinition("K45", "Hernia", "Other abdominal hernia", null, null));
        subcategories.add(new SubcategoryDefinition("K46", "Hernia", "Unspecified abdominal hernia", null, null));
        
        // Noninfective enteritis and colitis
        subcategories.add(new SubcategoryDefinition("K50", "Noninfective enteritis and colitis", "Crohn disease [regional enteritis]", null, null));
        subcategories.add(new SubcategoryDefinition("K51", "Noninfective enteritis and colitis", "Ulcerative colitis", null, null));
        subcategories.add(new SubcategoryDefinition("K52", "Noninfective enteritis and colitis", "Other and unspecified noninfective gastroenteritis and colitis", null, null));
        
        // Other diseases of intestines
        subcategories.add(new SubcategoryDefinition("K55", "Other diseases of intestines", "Vascular disorders of intestine", null, null));
        subcategories.add(new SubcategoryDefinition("K56", "Other diseases of intestines", "Paralytic ileus and intestinal obstruction", null, null));
        subcategories.add(new SubcategoryDefinition("K57", "Other diseases of intestines", "Diverticular disease of intestine", null, null));
        subcategories.add(new SubcategoryDefinition("K58", "Other diseases of intestines", "Irritable bowel syndrome", null, null));
        subcategories.add(new SubcategoryDefinition("K59", "Other diseases of intestines", "Other functional intestinal disorders", null, null));
        subcategories.add(new SubcategoryDefinition("K60", "Other diseases of intestines", "Fissure and fistula of anal and rectal regions", null, null));
        subcategories.add(new SubcategoryDefinition("K61", "Other diseases of intestines", "Abscess of anal and rectal regions", null, null));
        subcategories.add(new SubcategoryDefinition("K62", "Other diseases of intestines", "Other diseases of anus and rectum", null, null));
        subcategories.add(new SubcategoryDefinition("K63", "Other diseases of intestines", "Other diseases of intestine", null, null));
        subcategories.add(new SubcategoryDefinition("K64", "Other diseases of intestines", "Hemorrhoids and perianal venous thrombosis", null, null));
        
        // Diseases of liver
        subcategories.add(new SubcategoryDefinition("K70", "Diseases of liver", "Alcoholic liver disease", null, null));
        subcategories.add(new SubcategoryDefinition("K71", "Diseases of liver", "Toxic liver disease", null, null));
        subcategories.add(new SubcategoryDefinition("K72", "Diseases of liver", "Hepatic failure", null, null));
        subcategories.add(new SubcategoryDefinition("K73", "Diseases of liver", "Chronic hepatitis", null, null));
        subcategories.add(new SubcategoryDefinition("K74", "Diseases of liver", "Fibrosis and cirrhosis of liver", null, null));
        subcategories.add(new SubcategoryDefinition("K75", "Diseases of liver", "Other inflammatory liver diseases", null, null));
        subcategories.add(new SubcategoryDefinition("K76", "Diseases of liver", "Other diseases of liver", null, null));
        subcategories.add(new SubcategoryDefinition("K77", "Diseases of liver", "Liver disorders in diseases classified elsewhere", null, null));
        
        // Disorders of gallbladder, biliary tract and pancreas
        subcategories.add(new SubcategoryDefinition("K80", "Disorders of gallbladder, biliary tract and pancreas", "Cholelithiasis", null, null));
        subcategories.add(new SubcategoryDefinition("K81", "Disorders of gallbladder, biliary tract and pancreas", "Cholecystitis", null, null));
        subcategories.add(new SubcategoryDefinition("K82", "Disorders of gallbladder, biliary tract and pancreas", "Other diseases of gallbladder", null, null));
        subcategories.add(new SubcategoryDefinition("K83", "Disorders of gallbladder, biliary tract and pancreas", "Other diseases of biliary tract", null, null));
        subcategories.add(new SubcategoryDefinition("K85", "Disorders of gallbladder, biliary tract and pancreas", "Acute pancreatitis", null, null));
        subcategories.add(new SubcategoryDefinition("K86", "Disorders of gallbladder, biliary tract and pancreas", "Other diseases of pancreas", null, null));
        subcategories.add(new SubcategoryDefinition("K87", "Disorders of gallbladder, biliary tract and pancreas", "Disorders of gallbladder, biliary tract and pancreas in diseases classified elsewhere", null, null));
        
        // Other diseases of the digestive system
        subcategories.add(new SubcategoryDefinition("K90", "Other diseases of the digestive system", "Intestinal malabsorption", null, null));
        subcategories.add(new SubcategoryDefinition("K91", "Other diseases of the digestive system", "Intraoperative and postprocedural complications of digestive system", null, null));
        subcategories.add(new SubcategoryDefinition("K92", "Other diseases of the digestive system", "Other diseases of digestive system", null, null));
        subcategories.add(new SubcategoryDefinition("K94", "Other diseases of the digestive system", "Complications of artificial openings of the digestive system", null, null));
        subcategories.add(new SubcategoryDefinition("K95", "Other diseases of the digestive system", "Complications of bariatric procedures", null, null));
    }

    // Continue with remaining chapters... (Due to length, I'll provide a representative sample)
    // You can expand these similarly

    private void loadChapterL_Skin() {
        subcategories.add(new SubcategoryDefinition("L00", "Infections of the skin and subcutaneous tissue", "Staphylococcal scalded skin syndrome", null, null));
        subcategories.add(new SubcategoryDefinition("L01", "Infections of the skin and subcutaneous tissue", "Impetigo", null, null));
        subcategories.add(new SubcategoryDefinition("L02", "Infections of the skin and subcutaneous tissue", "Cutaneous abscess, furuncle and carbuncle", null, null));
        subcategories.add(new SubcategoryDefinition("L03", "Infections of the skin and subcutaneous tissue", "Cellulitis and acute lymphangitis", null, null));
        subcategories.add(new SubcategoryDefinition("L04", "Infections of the skin and subcutaneous tissue", "Acute lymphadenitis", null, null));
        subcategories.add(new SubcategoryDefinition("L05", "Infections of the skin and subcutaneous tissue", "Pilonidal cyst and sinus", null, null));
        subcategories.add(new SubcategoryDefinition("L08", "Infections of the skin and subcutaneous tissue", "Other local infections of skin and subcutaneous tissue", null, null));
        subcategories.add(new SubcategoryDefinition("L20", "Dermatitis and eczema", "Atopic dermatitis", null, null));
        subcategories.add(new SubcategoryDefinition("L21", "Dermatitis and eczema", "Seborrheic dermatitis", null, null));
        subcategories.add(new SubcategoryDefinition("L23", "Dermatitis and eczema", "Allergic contact dermatitis", null, null));
        subcategories.add(new SubcategoryDefinition("L24", "Dermatitis and eczema", "Irritant contact dermatitis", null, null));
        subcategories.add(new SubcategoryDefinition("L25", "Dermatitis and eczema", "Unspecified contact dermatitis", null, null));
        subcategories.add(new SubcategoryDefinition("L26", "Dermatitis and eczema", "Exfoliative dermatitis", null, null));
        subcategories.add(new SubcategoryDefinition("L27", "Dermatitis and eczema", "Dermatitis due to substances taken internally", null, null));
        subcategories.add(new SubcategoryDefinition("L28", "Dermatitis and eczema", "Lichen simplex chronicus and prurigo", null, null));
        subcategories.add(new SubcategoryDefinition("L29", "Dermatitis and eczema", "Pruritus", null, null));
        subcategories.add(new SubcategoryDefinition("L30", "Dermatitis and eczema", "Other and unspecified dermatitis", null, null));
        subcategories.add(new SubcategoryDefinition("L40", "Papulosquamous disorders", "Psoriasis", null, null));
        subcategories.add(new SubcategoryDefinition("L41", "Papulosquamous disorders", "Parapsoriasis", null, null));
        subcategories.add(new SubcategoryDefinition("L42", "Papulosquamous disorders", "Pityriasis rosea", null, null));
        subcategories.add(new SubcategoryDefinition("L43", "Papulosquamous disorders", "Lichen planus", null, null));
        subcategories.add(new SubcategoryDefinition("L44", "Papulosquamous disorders", "Other papulosquamous disorders", null, null));
        subcategories.add(new SubcategoryDefinition("L45", "Papulosquamous disorders", "Papulosquamous disorders in diseases classified elsewhere", null, null));
    }

    private void loadChapterM_Musculoskeletal() {
        // Arthropathies
        subcategories.add(new SubcategoryDefinition("M00", "Infectious arthropathies", "Pyogenic arthritis", null, null));
        subcategories.add(new SubcategoryDefinition("M01", "Infectious arthropathies", "Direct infections of joint in infectious and parasitic diseases classified elsewhere", null, null));
        subcategories.add(new SubcategoryDefinition("M02", "Infectious arthropathies", "Postinfective and reactive arthropathies", null, null));
        subcategories.add(new SubcategoryDefinition("M05", "Inflammatory polyarthropathies", "Rheumatoid arthritis with rheumatoid factor", null, null));
        subcategories.add(new SubcategoryDefinition("M06", "Inflammatory polyarthropathies", "Other rheumatoid arthritis", null, null));
        subcategories.add(new SubcategoryDefinition("M08", "Inflammatory polyarthropathies", "Juvenile arthritis", null, null));
        subcategories.add(new SubcategoryDefinition("M10", "Inflammatory polyarthropathies", "Gout", null, null));
        subcategories.add(new SubcategoryDefinition("M11", "Inflammatory polyarthropathies", "Other crystal arthropathies", null, null));
        subcategories.add(new SubcategoryDefinition("M12", "Inflammatory polyarthropathies", "Other and unspecified arthropathy", null, null));
        subcategories.add(new SubcategoryDefinition("M13", "Inflammatory polyarthropathies", "Other arthritis", null, null));
        subcategories.add(new SubcategoryDefinition("M14", "Inflammatory polyarthropathies", "Arthropathies in other diseases classified elsewhere", null, null));
        subcategories.add(new SubcategoryDefinition("M15", "Osteoarthritis", "Polyosteoarthritis", null, null));
        subcategories.add(new SubcategoryDefinition("M16", "Osteoarthritis", "Osteoarthritis of hip", null, null));
        subcategories.add(new SubcategoryDefinition("M17", "Osteoarthritis", "Osteoarthritis of knee", null, null));
        subcategories.add(new SubcategoryDefinition("M18", "Osteoarthritis", "Osteoarthritis of first carpometacarpal joint", null, null));
        subcategories.add(new SubcategoryDefinition("M19", "Osteoarthritis", "Other and unspecified osteoarthritis", null, null));
        
        // Dorsopathies
        subcategories.add(new SubcategoryDefinition("M40", "Deforming dorsopathies", "Kyphosis and lordosis", null, null));
        subcategories.add(new SubcategoryDefinition("M41", "Deforming dorsopathies", "Scoliosis", null, null));
        subcategories.add(new SubcategoryDefinition("M42", "Deforming dorsopathies", "Spinal osteochondrosis", null, null));
        subcategories.add(new SubcategoryDefinition("M43", "Deforming dorsopathies", "Other deforming dorsopathies", null, null));
        subcategories.add(new SubcategoryDefinition("M45", "Spondylopathies", "Ankylosing spondylitis", null, null));
        subcategories.add(new SubcategoryDefinition("M46", "Spondylopathies", "Other inflammatory spondylopathies", null, null));
        subcategories.add(new SubcategoryDefinition("M47", "Spondylopathies", "Spondylosis", null, null));
        subcategories.add(new SubcategoryDefinition("M48", "Spondylopathies", "Other spondylopathies", null, null));
        subcategories.add(new SubcategoryDefinition("M49", "Spondylopathies", "Spondylopathies in diseases classified elsewhere", null, null));
        subcategories.add(new SubcategoryDefinition("M50", "Other dorsopathies", "Cervical disc disorders", null, null));
        subcategories.add(new SubcategoryDefinition("M51", "Other dorsopathies", "Thoracic, thoracolumbar, and lumbosacral intervertebral disc disorders", null, null));
        subcategories.add(new SubcategoryDefinition("M53", "Other dorsopathies", "Other and unspecified dorsopathies", null, null));
        subcategories.add(new SubcategoryDefinition("M54", "Other dorsopathies", "Dorsalgia (back pain)", null, null));
        
        // Soft tissue disorders
        subcategories.add(new SubcategoryDefinition("M60", "Disorders of muscles", "Myositis", null, null));
        subcategories.add(new SubcategoryDefinition("M61", "Disorders of muscles", "Calcification and ossification of muscle", null, null));
        subcategories.add(new SubcategoryDefinition("M62", "Disorders of muscles", "Other disorders of muscle", null, null));
        subcategories.add(new SubcategoryDefinition("M63", "Disorders of muscles", "Disorders of muscle in diseases classified elsewhere", null, null));
        subcategories.add(new SubcategoryDefinition("M65", "Disorders of synovium and tendon", "Synovitis and tenosynovitis", null, null));
        subcategories.add(new SubcategoryDefinition("M66", "Disorders of synovium and tendon", "Spontaneous rupture of synovium and tendon", null, null));
        subcategories.add(new SubcategoryDefinition("M67", "Disorders of synovium and tendon", "Other disorders of synovium and tendon", null, null));
        subcategories.add(new SubcategoryDefinition("M70", "Other soft tissue disorders", "Soft tissue disorders related to use, overuse and pressure", null, null));
        subcategories.add(new SubcategoryDefinition("M71", "Other soft tissue disorders", "Other bursopathies", null, null));
        subcategories.add(new SubcategoryDefinition("M72", "Other soft tissue disorders", "Fibroblastic disorders", null, null));
        subcategories.add(new SubcategoryDefinition("M75", "Other soft tissue disorders", "Shoulder lesions", null, null));
        subcategories.add(new SubcategoryDefinition("M76", "Other soft tissue disorders", "Enthesopathies, lower limb", null, null));
        subcategories.add(new SubcategoryDefinition("M77", "Other soft tissue disorders", "Other enthesopathies", null, null));
        subcategories.add(new SubcategoryDefinition("M79", "Other soft tissue disorders", "Other and unspecified soft tissue disorders", null, null));
        
        // Bone disorders
        subcategories.add(new SubcategoryDefinition("M80", "Disorders of bone density and structure", "Osteoporosis with current pathological fracture", null, null));
        subcategories.add(new SubcategoryDefinition("M81", "Disorders of bone density and structure", "Osteoporosis without current pathological fracture", null, null));
        subcategories.add(new SubcategoryDefinition("M83", "Disorders of bone density and structure", "Adult osteomalacia", null, null));
        subcategories.add(new SubcategoryDefinition("M84", "Disorders of bone density and structure", "Disorder of continuity of bone", null, null));
        subcategories.add(new SubcategoryDefinition("M85", "Disorders of bone density and structure", "Other disorders of bone density and structure", null, null));
        subcategories.add(new SubcategoryDefinition("M86", "Other osteopathies", "Osteomyelitis", null, null));
        subcategories.add(new SubcategoryDefinition("M87", "Other osteopathies", "Osteonecrosis", null, null));
        subcategories.add(new SubcategoryDefinition("M88", "Other osteopathies", "Osteitis deformans [Paget disease of bone]", null, null));
        subcategories.add(new SubcategoryDefinition("M89", "Other osteopathies", "Other disorders of bone", null, null));
        subcategories.add(new SubcategoryDefinition("M90", "Other osteopathies", "Osteopathies in diseases classified elsewhere", null, null));
    }

    private void loadChapterN_Genitourinary() {
        // Glomerular diseases
        subcategories.add(new SubcategoryDefinition("N00", "Glomerular diseases", "Acute nephritic syndrome", null, null));
        subcategories.add(new SubcategoryDefinition("N01", "Glomerular diseases", "Rapidly progressive nephritic syndrome", null, null));
        subcategories.add(new SubcategoryDefinition("N02", "Glomerular diseases", "Recurrent and persistent hematuria", null, null));
        subcategories.add(new SubcategoryDefinition("N03", "Glomerular diseases", "Chronic nephritic syndrome", null, null));
        subcategories.add(new SubcategoryDefinition("N04", "Glomerular diseases", "Nephrotic syndrome", null, null));
        subcategories.add(new SubcategoryDefinition("N05", "Glomerular diseases", "Unspecified nephritic syndrome", null, null));
        subcategories.add(new SubcategoryDefinition("N06", "Glomerular diseases", "Isolated proteinuria with specified morphological lesion", null, null));
        subcategories.add(new SubcategoryDefinition("N07", "Glomerular diseases", "Hereditary nephropathy", null, null));
        subcategories.add(new SubcategoryDefinition("N08", "Glomerular diseases", "Glomerular disorders in diseases classified elsewhere", null, null));
        
        // Renal tubulo-interstitial diseases
        subcategories.add(new SubcategoryDefinition("N10", "Renal tubulo-interstitial diseases", "Acute pyelonephritis", null, null));
        subcategories.add(new SubcategoryDefinition("N11", "Renal tubulo-interstitial diseases", "Chronic tubulo-interstitial nephritis", null, null));
        subcategories.add(new SubcategoryDefinition("N12", "Renal tubulo-interstitial diseases", "Tubulo-interstitial nephritis, not specified as acute or chronic", null, null));
        subcategories.add(new SubcategoryDefinition("N13", "Renal tubulo-interstitial diseases", "Obstructive and reflux uropathy", null, null));
        subcategories.add(new SubcategoryDefinition("N14", "Renal tubulo-interstitial diseases", "Drug- and heavy-metal-induced tubulo-interstitial and tubular conditions", null, null));
        subcategories.add(new SubcategoryDefinition("N15", "Renal tubulo-interstitial diseases", "Other renal tubulo-interstitial diseases", null, null));
        subcategories.add(new SubcategoryDefinition("N16", "Renal tubulo-interstitial diseases", "Renal tubulo-interstitial disorders in diseases classified elsewhere", null, null));
        
        // Acute kidney failure and chronic kidney disease
        subcategories.add(new SubcategoryDefinition("N17", "Acute kidney failure and chronic kidney disease", "Acute kidney failure", null, null));
        subcategories.add(new SubcategoryDefinition("N18", "Acute kidney failure and chronic kidney disease", "Chronic kidney disease (CKD)", null, null));
        subcategories.add(new SubcategoryDefinition("N19", "Acute kidney failure and chronic kidney disease", "Unspecified kidney failure", null, null));
        
        // Urolithiasis
        subcategories.add(new SubcategoryDefinition("N20", "Urolithiasis", "Calculus of kidney and ureter", null, null));
        subcategories.add(new SubcategoryDefinition("N21", "Urolithiasis", "Calculus of lower urinary tract", null, null));
        subcategories.add(new SubcategoryDefinition("N22", "Urolithiasis", "Calculus of urinary tract in diseases classified elsewhere", null, null));
        subcategories.add(new SubcategoryDefinition("N23", "Urolithiasis", "Unspecified renal colic", null, null));
        
        // Other disorders of kidney and ureter
        subcategories.add(new SubcategoryDefinition("N25", "Other disorders of kidney and ureter", "Disorders resulting from impaired renal tubular function", null, null));
        subcategories.add(new SubcategoryDefinition("N26", "Other disorders of kidney and ureter", "Unspecified contracted kidney", null, null));
        subcategories.add(new SubcategoryDefinition("N27", "Other disorders of kidney and ureter", "Small kidney of unknown cause", null, null));
        subcategories.add(new SubcategoryDefinition("N28", "Other disorders of kidney and ureter", "Other disorders of kidney and ureter", null, null));
        subcategories.add(new SubcategoryDefinition("N29", "Other disorders of kidney and ureter", "Other disorders of kidney and ureter in diseases classified elsewhere", null, null));
        
        // Other diseases of the urinary system
        subcategories.add(new SubcategoryDefinition("N30", "Other diseases of the urinary system", "Cystitis", null, null));
        subcategories.add(new SubcategoryDefinition("N31", "Other diseases of the urinary system", "Neuromuscular dysfunction of bladder", null, null));
        subcategories.add(new SubcategoryDefinition("N32", "Other diseases of the urinary system", "Other disorders of bladder", null, null));
        subcategories.add(new SubcategoryDefinition("N33", "Other diseases of the urinary system", "Bladder disorders in diseases classified elsewhere", null, null));
        subcategories.add(new SubcategoryDefinition("N34", "Other diseases of the urinary system", "Urethritis and urethral syndrome", null, null));
        subcategories.add(new SubcategoryDefinition("N35", "Other diseases of the urinary system", "Urethral stricture", null, null));
        subcategories.add(new SubcategoryDefinition("N36", "Other diseases of the urinary system", "Other disorders of urethra", null, null));
        subcategories.add(new SubcategoryDefinition("N37", "Other diseases of the urinary system", "Urethral disorders in diseases classified elsewhere", null, null));
        subcategories.add(new SubcategoryDefinition("N39", "Other diseases of the urinary system", "Other disorders of urinary system", null, null));
        
        // Diseases of male genital organs
        subcategories.add(new SubcategoryDefinition("N40", "Diseases of male genital organs", "Benign prostatic hyperplasia", null, null));
        subcategories.add(new SubcategoryDefinition("N41", "Diseases of male genital organs", "Inflammatory diseases of prostate", null, null));
        subcategories.add(new SubcategoryDefinition("N42", "Diseases of male genital organs", "Other and unspecified disorders of prostate", null, null));
        subcategories.add(new SubcategoryDefinition("N43", "Diseases of male genital organs", "Hydrocele and spermatocele", null, null));
        subcategories.add(new SubcategoryDefinition("N44", "Diseases of male genital organs", "Noninflammatory disorders of testis", null, null));
        subcategories.add(new SubcategoryDefinition("N45", "Diseases of male genital organs", "Orchitis and epididymitis", null, null));
        subcategories.add(new SubcategoryDefinition("N46", "Diseases of male genital organs", "Male infertility", null, null));
        subcategories.add(new SubcategoryDefinition("N47", "Diseases of male genital organs", "Disorders of prepuce", null, null));
        subcategories.add(new SubcategoryDefinition("N48", "Diseases of male genital organs", "Other disorders of penis", null, null));
        subcategories.add(new SubcategoryDefinition("N49", "Diseases of male genital organs", "Inflammatory disorders of male genital organs", null, null));
        subcategories.add(new SubcategoryDefinition("N50", "Diseases of male genital organs", "Other and unspecified disorders of male genital organs", null, null));
        subcategories.add(new SubcategoryDefinition("N51", "Diseases of male genital organs", "Disorders of male genital organs in diseases classified elsewhere", null, null));
        subcategories.add(new SubcategoryDefinition("N52", "Diseases of male genital organs", "Male erectile dysfunction", null, null));
        subcategories.add(new SubcategoryDefinition("N53", "Diseases of male genital organs", "Other male sexual dysfunction", null, null));
    }

    // Add stub methods for remaining chapters (to avoid compilation errors)
    private void loadChapterO_Pregnancy() {
        // Pregnancy complications - add as needed
        subcategories.add(new SubcategoryDefinition("O00", "Pregnancy with abortive outcome", "Ectopic pregnancy", null, null));
        subcategories.add(new SubcategoryDefinition("O10", "Edema, proteinuria and hypertensive disorders in pregnancy, childbirth and the puerperium", "Pre-existing hypertension complicating pregnancy", null, null));
    }

    private void loadChapterP_Perinatal() {
        subcategories.add(new SubcategoryDefinition("P07", "Disorders of newborn related to length of gestation and fetal growth", "Disorders of newborn related to short gestation and low birth weight", null, null));
    }

    private void loadChapterQ_Congenital() {
        subcategories.add(new SubcategoryDefinition("Q20", "Congenital malformations of the circulatory system", "Congenital malformations of cardiac chambers and connections", null, null));
    }

    private void loadChapterR_SymptomsAndSigns() {
        subcategories.add(new SubcategoryDefinition("R00", "Symptoms and signs involving the circulatory and respiratory systems", "Abnormalities of heart beat", null, null));
        subcategories.add(new SubcategoryDefinition("R10", "Symptoms and signs involving the digestive system and abdomen", "Abdominal and pelvic pain", null, null));
        subcategories.add(new SubcategoryDefinition("R50", "General symptoms and signs", "Fever of other and unknown origin", null, null));
    }

    private void loadChapterS_T_Injury() {
        subcategories.add(new SubcategoryDefinition("S00", "Injuries to the head", "Superficial injury of head", null, null));
        subcategories.add(new SubcategoryDefinition("S06", "Injuries to the head", "Intracranial injury", null, null));
        subcategories.add(new SubcategoryDefinition("T14", "Injury of unspecified body region", "Injury of unspecified body region", null, null));
    }

    private void loadChapterV_Y_ExternalCauses() {
        subcategories.add(new SubcategoryDefinition("V01", "Transport accidents", "Pedestrian injured in collision with pedal cycle", null, null));
        subcategories.add(new SubcategoryDefinition("W00", "Slipping, tripping, stumbling and falls", "Fall due to ice and snow", null, null));
    }

    private void loadChapterZ_HealthStatus() {
        subcategories.add(new SubcategoryDefinition("Z00", "Persons encountering health services for examinations", "Encounter for general examination without complaint", null, null));
        subcategories.add(new SubcategoryDefinition("Z23", "Persons encountering health services for examinations", "Encounter for immunization", null, null));
    }



    // Find subcategory for a code
    public SubcategoryDefinition getSubcategory(String code) {
        // Try to match level 2 first (more specific)
        for (SubcategoryDefinition def : subcategories) {
            if (def.matchesLevel2(code)) {
                return def;
            }
        }
        
        // Then try level 1
        for (SubcategoryDefinition def : subcategories) {
            if (def.matchesSubcategory(code) && def.getLevel2Prefix() == null) {
                return def;
            }
        }
        
        return null;
    }
    
    // Get all subcategories
    public List<SubcategoryDefinition> getAllSubcategories() {
        return subcategories;
    }
}
