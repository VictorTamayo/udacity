import os

def rename_files():
    #(1) get file names from folder
    file_list = os.listdir(r"C:\Users\victo\Documents\GitHub\udacity\ud036\prank")
    #print(file_list)
    #(2) for each file, rename file
    os.chdir(r"C:\Users\victo\Documents\GitHub\udacity\ud036\prank")
    for file_name in file_list:
        dst_file = file_name.translate(None, "0123456789")
        os.rename(file_name, dst_file)

rename_files()
