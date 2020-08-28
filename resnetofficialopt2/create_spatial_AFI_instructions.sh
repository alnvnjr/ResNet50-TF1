#!/bin/bash
# Instructions to upload bitstream to S3 and create AFI
cd /home/centos/src/project_data/aws-fpga//hdk/cl/examples/resnetofficialopt2
too_many_buckets=`cat log | grep TooManyBuckets | wc -l`
if [[ ${too_many_buckets} -ne 0 ]]; then echo "Too many buckets error.  Delete some in S3"; exit 1; fi
aws s3 cp build/checkpoints/to_aws/*.Developer_CL.tar s3://resnetofficialopt2/dcp/ | tee log
tarname=`cat log | grep "Developer_CL.tar" -m 1 | rev | cut -d/ -f1 | rev`
if [[ -z $tarname ]]; then echo "No tarname found!"; exit 1; fi
aws s3 mb s3://resnetofficialopt2/logs | tee log
touch LOGS_FILES_GO_HERE.txt
aws s3 cp LOGS_FILES_GO_HERE.txt s3://resnetofficialopt2/logs/ 2>&1 | tee log

# Create the FPGA Image.
# If this command fails, you may need a different awscli version. We tested with version 1.11.78.
# Important: Replace <tarball-name> below with the name of the tarball file copied to S3 above,
#            e.g. replace <tarball-name> with 17_10_06-######.Developer_CL.tar.
aws ec2 create-fpga-image \
--name resnetofficialopt2 \
--input-storage-location Bucket=resnetofficialopt2,Key=dcp/$tarname \
--logs-storage-location Bucket=resnetofficialopt2,Key=logs/ | tee fpgaIds

# Keep a record of the afi and agfi IDs returned above.
# Now wait for the logs to be created in S3. The State file should indicate that the AFI is available
# Once that is done, see the online Spatial AWS documentation for how to open and run on an F1 instance.
echo "FpgaImageId and FpgaImageGlobalId stored in `pwd`/fpgaIds" 

