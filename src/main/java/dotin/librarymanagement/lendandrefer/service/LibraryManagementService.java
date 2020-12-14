package dotin.librarymanagement.lendandrefer.service;

import dotin.librarymanagement.lendandrefer.model.LendingModel;

public interface LibraryManagementService {

    boolean insertDocumentData(LendingModel lendingModel);

    void changeBookStatus(Long var);

}
